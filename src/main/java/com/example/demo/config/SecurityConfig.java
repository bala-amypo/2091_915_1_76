package com.example.demo.config;

import com.example.demo.security.CustomUserDetailsService;
import com.example.demo.security.JwtAuthenticationFilter;
import com.example.demo.security.JwtTokenProvider;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    // ✅ JWT provider bean
    @Bean
    public JwtTokenProvider jwtTokenProvider() {
        return new JwtTokenProvider(
                "THIS_IS_A_TEST_32_CHAR_MINIMUM_SECRET_KEY_!!!",
                3600000L
        );
    }

    // ✅ in-memory user service bean
    @Bean
    public CustomUserDetailsService customUserDetailsService() {
        return new CustomUserDetailsService();
    }

    // ✅ JWT filter bean
    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter(
            JwtTokenProvider jwtTokenProvider,
            CustomUserDetailsService userDetailsService) {

        return new JwtAuthenticationFilter(jwtTokenProvider, userDetailsService);
    }

    // ✅ security chain
    @Bean
    public SecurityFilterChain filterChain(
            HttpSecurity http,
            JwtAuthenticationFilter jwtFilter) throws Exception {

        http
            .formLogin(form -> form.disable())
            .httpBasic(basic -> basic.disable())
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                .requestMatchers(
                        "/auth/**",
                        "/swagger-ui/**",
                        "/v3/api-docs/**"
                ).permitAll()
                .anyRequest().authenticated()
            )
            .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
