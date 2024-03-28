package com.levinine.codenine.secured.services;

import com.levinine.codenine.secured.dtos.UserDto;
import com.levinine.codenine.secured.entities.User;
import com.levinine.codenine.secured.exceptions.UnauthorizedException;

public interface UserService {
    String login(UserDto userDto) throws UnauthorizedException;
    User save(UserDto user);
}
