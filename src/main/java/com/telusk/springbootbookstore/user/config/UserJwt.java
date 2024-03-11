package com.telusk.springbootbookstore.user.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Component;
import java.util.Base64;

@Component
public class UserJwt {
    private static final String SECRET_KEY = "Heeneth";

    public String createToken(Long userId) {
        return JWT.create()
                .withClaim("userId", userId)
                .sign(Algorithm.HMAC256(Base64.getEncoder().encode(SECRET_KEY.getBytes())));
    }

    public String decodeToken(String token) {
        try {
            String userId = JWT.require(Algorithm.HMAC256(Base64.getEncoder().encode(SECRET_KEY.getBytes())))
                    .build()
                    .verify(token)
                    .getClaim("userId")
                    .asString();

            return userId;
        } catch (Exception e) {
            // Handle token decoding exception
            return null;
        }
    }

}
