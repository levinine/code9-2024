package com.levinine.codenine.secured.services;

import org.springframework.security.core.userdetails.UserDetails;

import com.levinine.codenine.secured.entities.User;

import io.jsonwebtoken.Claims;

public interface JwtService {
    String extractUsername(String jwt);
    Claims extractClaims(String jwt);
    boolean isTokeValid(Claims claims, UserDetails userDetails);
    String generateToken(User user);
}
