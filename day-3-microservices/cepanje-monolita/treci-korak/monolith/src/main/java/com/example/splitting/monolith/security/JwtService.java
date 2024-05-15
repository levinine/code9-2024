package com.example.splitting.monolith.security;

import com.example.splitting.monolith.entities.User;
import io.jsonwebtoken.Claims;
import org.springframework.security.core.userdetails.UserDetails;

public interface JwtService {
    String extractUsername(String jwt);
    Claims extractClaims(String jwt);
    boolean isTokenValid(Claims claims, UserDetails userDetails);
    String generateToken(User user);
}
