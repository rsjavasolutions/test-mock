package com.rsjava.testmock.service;

import com.rsjava.testmock.model.User;
import com.rsjava.testmock.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public List<User> getActiveUsers(){
        return userRepository.findAll().stream()
                .filter(user -> user.isActive())
                .collect(Collectors.toList());
    }

    public List<User> getActiveSuperUsers(){
        return userRepository.findAll().stream()
                .filter(user -> user.isActive())
                .filter(user -> user.isSuperuser())
                .collect(Collectors.toList());
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }
}
