package com.eureka.tiny.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import java.util.Map;

public class JwtUtil {
    private static final String KEY = "eureka";  // 更加复杂的密钥

    /**
     * 生成 JWT Token
     */
    public static String genToken(Map<String, Object> claims) {
        return JWT.create()
                .withClaim("claims", claims)
                .sign(Algorithm.HMAC256(KEY));  // 使用 HMAC256 加密
    }

    /**
     * 解析 JWT Token
     */
    public static Map<String, Object> parseToken(String token) {
        try {
            return JWT.require(Algorithm.HMAC256(KEY))
                    .build()
                    .verify(token)
                    .getClaim("claims")
                    .asMap();
        } catch (JWTVerificationException e) {
            return null;  // 返回 null 表示 token 无效或已过期
        }
    }
}
