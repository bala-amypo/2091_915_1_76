package com.example.demo.controller;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.security.CustomUserDetailsService;
import com.example.demo.security.JwtTokenProvider;
import com.example.demo.security.UserPrincipal;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final CustomUserDetailsService userService;
    private final JwtTokenProvider jwtProvider;

    public AuthController(CustomUserDetailsService userService,
                          JwtTokenProvider jwtProvider) {
        this.userService = userService;
        this.jwtProvider = jwtProvider;
    }

    @PostMapping("/register")
    public String register(@RequestBody AuthRequest req) {
        userService.register(req.getUsername(), req.getPassword(), "USER");
        return "registered";
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest req) {

        UserPrincipal user =
                (UserPrincipal) userService.loadUserByUsername(req.getUsername());

        String token = jwtProvider.generateToken(user);

        return new AuthResponse(token);
    }
}
