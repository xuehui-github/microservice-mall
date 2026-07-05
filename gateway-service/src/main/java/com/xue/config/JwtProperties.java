package com.xue.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
@ConfigurationProperties(prefix = "jwt")
public class JwtProperties {

    /** HMAC-SHA secret key (Base64-encoded, at least 256 bits / 32 bytes). */
    private String secret = "ZGVmYXVsdC1zZWNyZXQtY2hhbmdlLW1lLWluLXByb2R1Y3Rpb24tWVdKalphbVJsWm1kcGJtdHNiVzV2Y0E9PQ==";

    /** Token expiration in milliseconds. Default: 24 hours. */
    private long expiration = 86_400_000L;

    /** Path patterns that skip JWT authentication (Ant-style). */
    private List<String> excludePaths = List.of(
            "/actuator/**",
            "/swagger-ui/**",
            "/v3/api-docs/**",
            "/eureka/**"
    );
}
