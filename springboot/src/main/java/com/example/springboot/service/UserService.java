package com.example.springboot.service;

import com.example.springboot.entity.User;

import java.util.Optional;

public interface UserService {

    User registerUser(User user);

    Optional<User> getUserByUsername(String username);

    Optional<User> getUserByEmail(String email);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);
}
