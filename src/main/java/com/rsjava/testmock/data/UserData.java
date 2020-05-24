package com.rsjava.testmock.data;

import com.rsjava.testmock.model.User;
import com.rsjava.testmock.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserData implements CommandLineRunner {

    private UserService userService;

    @Autowired
    public UserData(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {

        userService.saveUser(new User("kowalski", true, true));
        userService.saveUser(new User("kowalski 2", false, true));
        userService.saveUser(new User("kowalski 3", true, false));
        userService.saveUser(new User("kowalski 4", false, true));
        userService.saveUser(new User("kowalski 5", true, true));
        userService.saveUser(new User("kowalski 6", true, true));
        userService.saveUser(new User("kowalski 7", false, true));
        userService.saveUser(new User("kowalski 8", true, true));
        userService.saveUser(new User("kowalski 9", true, false));
        userService.saveUser(new User("kowalski 10", true, true));

    }
}
