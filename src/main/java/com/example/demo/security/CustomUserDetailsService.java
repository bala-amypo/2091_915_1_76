package com.example.demo.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class CustomUserDetailsService implements UserDetailsService {

    private final Map<String, UserPrincipal> users = new ConcurrentHashMap<>();
    private final AtomicLong idGen = new AtomicLong(1);

    public UserPrincipal register(String username, String password, String role) {
        UserPrincipal user = new UserPrincipal(
                idGen.getAndIncrement(),
                username,
                password,
                role
        );
        users.put(username, user);
        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        UserPrincipal user = users.get(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return user;
    }
}
