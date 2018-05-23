package com.admaxim.BootJs.service;

import com.admaxim.BootJs.model.User;

import java.util.List;
import java.util.Optional;


public interface IUserService {

    Optional<User> findById(Long userId);

    User findByName(String name);

    User saveUser(User user);

    User updateUser(User user);

    void deleteUserById(Long userId);

    void deleteAllUsers();

    List<User> findAllUsers();

    Boolean isUserExist(User user);
}
