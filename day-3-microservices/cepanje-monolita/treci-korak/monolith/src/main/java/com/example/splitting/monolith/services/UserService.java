package com.example.splitting.monolith.services;

import com.example.splitting.monolith.entities.User;
import com.example.splitting.monolith.exceptions.UnauthorizedException;

import java.util.Optional;

public interface UserService {
    User saveNewUser(String username, String password);
    String login(String username, String password) throws UnauthorizedException;
    Optional<User> getUser(Long id);
    Optional<User> getUser(String username);
}
