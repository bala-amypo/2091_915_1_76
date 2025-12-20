package com.example.demo.security;

public class JwtTokenProvider {

    public JwtTokenProvider() {
        // dummy constructor
    }

    public String generateToken(String username) {
        return "dummy-token";
    }

    public boolean validateToken(String token) {
        return true;
    }

    public String getUsernameFromToken(String token) {
        return "dummy-user";
    }
}
