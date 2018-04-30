package com.spring.sims.simspro.service;

import com.spring.sims.simspro.model.User;

import java.util.List;

public interface UserService {
    public User getUserById(Long id);
    public  void saveUser(User user);
    public  void updateUser(User user);
    public  void deleteUser(Long id);
    public List<User> getAllUsers();

    User getUserByUserName(String userName);
}
