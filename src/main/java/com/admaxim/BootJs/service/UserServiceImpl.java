package com.admaxim.BootJs.service;

import com.admaxim.BootJs.model.User;
import com.admaxim.BootJs.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service("iUserService")
@Transactional
public class UserServiceImpl implements IUserService {
    //imp-cache

    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<User> findById(Long userId) { return userRepository.findById(userId); }

    @Override
    public User findByName(String name) { return userRepository.findByName(name); }

    @Override
    public User saveUser(User user) { return userRepository.save(user); }

    @Override
    public User updateUser(User user) { return saveUser(user); }

    @Override
    public void deleteUserById(Long userId) { userRepository.deleteById(userId); }

    @Override
    public void deleteAllUsers() { userRepository.deleteAll(); }

    @Override
    public List<User> findAllUsers() { return userRepository.findAll(); }

    @Override
    public Boolean isUserExist(User user) { return findByName(user.getName()) != null; }

}
