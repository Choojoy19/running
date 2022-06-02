package com.example.running.service;

import com.example.running.models.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findById(Integer id);
    User findByName(String name);
    User save(User user);
}
