package com.example.mythymeleaf2.repository;

import com.example.mythymeleaf2.model.User;

import java.util.List;

public interface CustomizedUserRepository {
    List<User> findByCustomUsername(String username);
}
