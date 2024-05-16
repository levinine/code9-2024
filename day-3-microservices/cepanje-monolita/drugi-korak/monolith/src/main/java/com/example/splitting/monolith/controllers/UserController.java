package com.example.splitting.monolith.controllers;

import com.example.splitting.monolith.dtos.LoginResponseDto;
import com.example.splitting.monolith.dtos.SaveUserDto;
import com.example.splitting.monolith.dtos.UserDto;
import com.example.splitting.monolith.exceptions.NotFoundException;
import com.example.splitting.monolith.exceptions.UnauthorizedException;
import com.example.splitting.monolith.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/v1")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/users/by-id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    UserDto getUserById(@PathVariable(name = "id")Long id) throws NotFoundException {
        var user = userService.getUser(id).orElseThrow(() -> new NotFoundException("user not found"));
        return UserDto.fromUser(user);
    }

    @GetMapping(path = "/users/by-username/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
    UserDto getUserByUsername(@PathVariable(name = "username") String username) throws NotFoundException {
        var user = userService.getUser(username).orElseThrow(() -> new NotFoundException("user not found"));
        return UserDto.fromUser(user);
    }

    @PostMapping(path = "/users/register", consumes = MediaType.APPLICATION_JSON_VALUE)
    void register(@RequestBody SaveUserDto dto) {
        userService.saveNewUser(dto.username(), dto.password());
    }

    @PostMapping(
            path = "/users/login",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    LoginResponseDto login(@RequestBody SaveUserDto dto) throws UnauthorizedException {
        var token = userService.login(dto.username(), dto.password());
        return new LoginResponseDto(token);
    }

    @Secured("ROLE_ADMIN")
    @GetMapping(path = "/hello/admin")
    ResponseEntity<Void> helloAdmin() {
        return ResponseEntity.ok(null);
    }

    @Secured("ROLE_USER")
    @GetMapping(path = "/hello/user")
    ResponseEntity<Void> helloUser() {
        return ResponseEntity.ok(null);
    }

    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    @GetMapping(path = "/hello/admin-user")
    ResponseEntity<Void> helloAdminOrUser() {
        return ResponseEntity.ok(null);
    }
}
