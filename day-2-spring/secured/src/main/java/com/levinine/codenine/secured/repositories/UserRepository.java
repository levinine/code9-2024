package com.levinine.codenine.secured.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.levinine.codenine.secured.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);
    Optional<User> findByUsernameAndPassword(String username, String password);
}
