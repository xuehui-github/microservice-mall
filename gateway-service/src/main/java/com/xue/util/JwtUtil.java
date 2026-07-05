package com.xue.util;

import com.xue.config.JwtProperties;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SecurityException;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Base64;
import java.util.Date;
import java.util.Map;

@Slf4j
@Component
@RequiredArgsConstructor
public class JwtUtil {

    private final JwtProperties jwtProperties;
    private JwtParser jwtParser;

    @PostConstruct
    public void init() {
        byte[] keyBytes = Base64.getDecoder().decode(jwtProperties.getSecret());
        SecretKey key = Keys.hmacShaKeyFor(keyBytes);
        this.jwtParser = Jwts.parser()
                .verifyWith(key)
                .build();
        log.info("JWT parser initialized with HMAC-SHA key ({} bits)", keyBytes.length * 8);
    }

    /**
     * Generate a signed JWT token for the given user.
     * In production, token generation belongs in a dedicated auth service.
     *
     * @param userId   user identifier (becomes the JWT subject)
     * @param username human-readable username
     * @return signed JWT string
     */
    public String generateToken(String userId, String username) {
        byte[] keyBytes = Base64.getDecoder().decode(jwtProperties.getSecret());
        SecretKey key = Keys.hmacShaKeyFor(keyBytes);
        Date now = new Date();
        Date expiration = new Date(now.getTime() + jwtProperties.getExpiration());

        return Jwts.builder()
                .subject(userId)
                .claim("username", username)
                .issuedAt(now)
                .expiration(expiration)
                .signWith(key)
                .compact();
    }

    /**
     * Parse and validate a JWT token string.
     *
     * @param token raw JWT string (without "Bearer " prefix)
     * @return parsed claims
     * @throws ExpiredJwtException      token is expired
     * @throws SecurityException        signature is invalid
     * @throws MalformedJwtException    token structure is invalid
     * @throws UnsupportedJwtException  token type is unsupported
     * @throws IllegalArgumentException token is null or empty
     */
    public Claims parseToken(String token) {
        return jwtParser.parseSignedClaims(token).getPayload();
    }

    /**
     * Print a ready-to-use test token at startup for manual testing.
     */
    @PostConstruct
    public void printTestToken() {
        String token = generateToken("user-001", "admin");
        log.info("==============================");
        log.info("  Test JWT Token (valid 24h):");
        log.info("  {}", token);
        log.info("==============================");
        log.info("  Use: curl -H 'Authorization: Bearer {}' http://localhost:10010/user/1", token);
    }
}
