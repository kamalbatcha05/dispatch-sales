package com.application.dispatch.service;

import com.application.dispatch.entity.User;

import java.util.List;

public interface UserService {
    User findUserByEmail(String email);
    void saveUser(User user);
    void registerUser(User user);
    List<User> getAllUsers();
}
