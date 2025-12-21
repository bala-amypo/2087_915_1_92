package com.example.demo.config;

import io.jsonwebtoken.Claims;
import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    public String generateToken(Long userId, String email, String role) {
        return "token";
    }

    public Claims parseToken(String token) {
        return null;
    }
}