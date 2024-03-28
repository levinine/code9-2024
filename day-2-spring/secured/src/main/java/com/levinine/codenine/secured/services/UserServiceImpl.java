package com.levinine.codenine.secured.services;

import java.security.SecureRandom;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.levinine.codenine.secured.dtos.UserDto;
import com.levinine.codenine.secured.entities.Role;
import com.levinine.codenine.secured.entities.User;
import com.levinine.codenine.secured.entities.UserRole;
import com.levinine.codenine.secured.exceptions.UnauthorizedException;
import com.levinine.codenine.secured.repositories.UserRepository;

@Component
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(
        UserRepository userRepository,
        JwtService jwtService,
        AuthenticationManager authenticationManager,
        PasswordEncoder passwordEncoder
    ) {
        this.userRepository = userRepository;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public String login(UserDto userDto) throws UnauthorizedException {
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(userDto.username(), userDto.password())
        );

        var user = userRepository.findByUsername(userDto.username())
                .orElseThrow(() -> new UnauthorizedException("username or password are incorrect"));
        if (!passwordEncoder.matches(userDto.password(), user.getPassword())) {
            throw new UnauthorizedException("username or password are incorrect");
        }

        return jwtService.generateToken(user);
    }

    @Override
    public User save(UserDto userDto) {
        var user = User.builder()
            .username(userDto.username())
            .password(passwordEncoder.encode(userDto.password()))
            .build();
        var userRole = UserRole.builder()
            .role(Role.USER)
            .user(user)
            .build();
        user.setRoles(List.of(userRole));
        return userRepository.save(user);
    }
}
