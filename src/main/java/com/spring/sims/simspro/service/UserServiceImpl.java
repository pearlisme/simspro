package com.spring.sims.simspro.service;

import com.spring.sims.simspro.model.User;
import com.spring.sims.simspro.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;


//    @Transactional
    @Override
    public User getUserById(Long id) {
        return userRepository.getOne(id);
    }

//    @Transactional
    @Override
    public void saveUser(User user) {
        userRepository.saveAndFlush(user);
    }

//    @Transactional
    @Override
    public void updateUser(User user) {
        userRepository.save(user);
    }

//    @Transactional
    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    //    @Transactional
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserByUserName(String userName) {
        for (User user : getAllUsers()) {
            if (userName.equals(user.getUserName())) {
                return user;
            }
        }
        return null;
    }

    public User getUser(User userP) {
        for (User user : getAllUsers()) {
            if (userP.getUserName() == user.getUserName()) {
                return user;
            }
        }

        return null;
    }
}
