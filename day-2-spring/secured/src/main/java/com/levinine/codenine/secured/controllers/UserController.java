package com.levinine.codenine.secured.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.levinine.codenine.secured.dtos.LoginDto;
import com.levinine.codenine.secured.dtos.UserDto;
import com.levinine.codenine.secured.exceptions.UnauthorizedException;
import com.levinine.codenine.secured.services.UserService;

@RestController
@RequestMapping(path = "/users")
public class UserController {

    private UserService userService;
    
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(path = "/register", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> register(@RequestBody UserDto userDto) {
        userService.save(userDto);
        return ResponseEntity.ok().build();
    }

    @PostMapping(path = "/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public LoginDto login(@RequestBody UserDto userDto) throws UnauthorizedException {
        var token = userService.login(userDto);
        return new LoginDto(token);
    }
}
