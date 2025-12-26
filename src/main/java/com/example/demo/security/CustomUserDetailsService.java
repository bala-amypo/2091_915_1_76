package com.example.demo.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.HashMap;
import java.util.Map;

public class CustomUserDetailsService {

    private final Map<String, UserPrincipal> users = new HashMap<>();
    private long idSequence = 1L;

    public UserPrincipal register(String email, String password, String role) {
        UserPrincipal user =
                new UserPrincipal(idSequence++, email, password, role);
        users.put(email, user);
        return user;
    }

    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        UserPrincipal user = users.get(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return user;
    }
}
