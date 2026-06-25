package com.xue.configure;

import com.xue.config.JwtProperties;
import com.xue.util.JwtUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.security.SecurityException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;

@Order(Ordered.HIGHEST_PRECEDENCE)
@Component
@Slf4j
@RequiredArgsConstructor
public class AuthorizeFilter implements GlobalFilter {

    private final JwtUtil jwtUtil;
    private final JwtProperties jwtProperties;
    private final AntPathMatcher pathMatcher = new AntPathMatcher();

    private static final String BEARER_PREFIX = "Bearer ";

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        String path = request.getURI().getPath();

        // 1. 路径白名单 —— 匹配的路径跳过鉴权
        if (isExcludedPath(path)) {
            log.debug("Path {} is excluded from JWT authentication", path);
            return chain.filter(exchange);
        }

        // 2. 提取 Authorization 头
        String authHeader = request.getHeaders().getFirst(HttpHeaders.AUTHORIZATION);
        if (authHeader == null || !authHeader.startsWith(BEARER_PREFIX)) {
            log.warn("Missing or malformed Authorization header on path: {}", path);
            return unauthorized(exchange, "Missing or invalid Authorization header. Expected: Bearer <token>");
        }

        String token = authHeader.substring(BEARER_PREFIX.length()).trim();
        if (token.isEmpty()) {
            log.warn("Empty JWT token received on path: {}", path);
            return unauthorized(exchange, "Token must not be empty");
        }

        // 3. 解析并校验 JWT
        Claims claims;
        try {
            claims = jwtUtil.parseToken(token);
        } catch (ExpiredJwtException e) {
            log.warn("Expired JWT token on path: {}. Expired at: {}", path, e.getClaims().getExpiration());
            return unauthorized(exchange, "Token has expired");
        } catch (SecurityException | MalformedJwtException e) {
            log.warn("Invalid JWT signature or malformed token on path: {}", path);
            return unauthorized(exchange, "Invalid token");
        } catch (UnsupportedJwtException e) {
            log.warn("Unsupported JWT token on path: {}", path);
            return unauthorized(exchange, "Unsupported token format");
        } catch (IllegalArgumentException e) {
            log.warn("Illegal JWT token argument on path: {}", path);
            return unauthorized(exchange, "Token parsing error");
        }

        // 4. 从 Claims 中提取用户身份
        String userId = claims.getSubject();
        String username = claims.get("username", String.class);

        log.debug("JWT authenticated: userId={}, username={}, path={}", userId, username, path);

        // 5. 将用户信息透传到下游服务
        ServerHttpRequest mutatedRequest = request.mutate()
                .header("X-User-Id", userId)
                .header("X-User-Name", username != null ? username : "")
                .build();

        return chain.filter(exchange.mutate().request(mutatedRequest).build());
    }

    /**
     * 检查请求路径是否匹配白名单模式。
     */
    private boolean isExcludedPath(String path) {
        return jwtProperties.getExcludePaths().stream()
                .anyMatch(pattern -> pathMatcher.match(pattern, path));
    }

    /**
     * 构造标准化的 401 JSON 响应体。
     */
    private Mono<Void> unauthorized(ServerWebExchange exchange, String message) {
        exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
        exchange.getResponse().getHeaders().setContentType(MediaType.APPLICATION_JSON);

        String body = String.format(
                "{\"error\":\"Unauthorized\",\"message\":\"%s\",\"timestamp\":\"%s\"}",
                message, java.time.Instant.now().toString()
        );

        DataBuffer buffer = exchange.getResponse().bufferFactory()
                .wrap(body.getBytes(StandardCharsets.UTF_8));
        return exchange.getResponse().writeWith(Mono.just(buffer));
    }
}
