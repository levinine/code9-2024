package com.example.splitting.monolith.services;

import com.example.splitting.monolith.entities.User;
import com.example.splitting.monolith.entities.UserRole;
import com.example.splitting.monolith.exceptions.UnauthorizedException;
import com.example.splitting.monolith.repositories.UserRepository;
import com.example.splitting.monolith.security.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;

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
    public User saveNewUser(String username, String password) {
        return userRepository.save(
                User.builder()
                        .username(username)
                        .passwordHash(passwordEncoder.encode(password))
                        .userRole(UserRole.ADMIN)
                        .build()
        );
    }

    @Override
    public String login(String username, String password) throws UnauthorizedException {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password)
        );

        var user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UnauthorizedException("username or password are incorrect"));
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new UnauthorizedException("username or password are incorrect");
        }

        return jwtService.generateToken(user);
    }

    @Override
    public Optional<User> getUser(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> getUser(String username) {
        return userRepository.findByUsername(username);
    }
}
