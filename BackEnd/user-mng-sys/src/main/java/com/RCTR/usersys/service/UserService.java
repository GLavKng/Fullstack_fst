package com.RCTR.usersys.service;

import java.util.List;

import com.RCTR.usersys.model.User;

public interface UserService {
    User saveUser(User user);

    List<User> getAllUsers();

    User getUserById(Long id);

    boolean deleteUser(Long id);

    User updateUser(Long id, User user);
}
