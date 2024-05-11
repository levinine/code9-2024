package com.example.splitting.monolith.dtos;

import com.example.splitting.monolith.entities.User;

public record UserDto(Long id, String username) {
    static public UserDto fromUser(User user) {
        return user == null ?
                null :
                new UserDto(
                        user.getId(),
                        user.getUsername()
                );
    }
}
