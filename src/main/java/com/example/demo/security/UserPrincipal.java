package com.example.demo.security;

public class UserPrincipal {

    private String username;

    public UserPrincipal(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
