package com.rsjava.testmock.controller;

import com.rsjava.testmock.model.User;
import com.rsjava.testmock.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/users/active")
    public List<User> getActiveUsers(){
        return userService.getActiveUsers();
    }

    @GetMapping("/users/superusers")
    public List<User> getActiveSuperUsers(){
        return userService.getActiveSuperUsers();
    }
}
