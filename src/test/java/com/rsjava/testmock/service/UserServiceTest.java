package com.rsjava.testmock.service;

import com.rsjava.testmock.model.User;
import com.rsjava.testmock.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.INPUT_STREAM;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    //tworzę stałą żeby zmienna boolean była czytelniejsza w code review;
    public static final boolean ACTIVE = true;
    public static final boolean IS_SUPERUSER = true;
    public static final boolean IS_NOT_SUPERUSER = false;
    public static final boolean INACTIVE = false;

    @Mock
    UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    void setUp() {
        when(userRepository.findAll()).thenReturn(Arrays.asList(
                new User(1l, "test1", ACTIVE, IS_SUPERUSER),
                new User(2l, "test2", ACTIVE, IS_NOT_SUPERUSER),
                new User(3l, "test3", INACTIVE, IS_SUPERUSER)
        ));
    }

    @Test
    void shouldGetAllUsers() {
        //given
        //when
        List<User> allUsers = userService.getAllUsers();

        //then
        assertThat(allUsers).hasSize(3);
    }

    @Test
    void shouldGetActiveUsers() {
        //when
        List<User> activeUsers = userService.getActiveUsers();

        //then
        assertThat(activeUsers).hasSize(2);
        assertThat(activeUsers).extracting("active").containsOnly(true);
    }

    @Test
    void shouldGetActiveSuperUsers() {
        //when
        List<User> activeSuperUsers = userService.getActiveSuperUsers();

        //then
        assertThat(activeSuperUsers).hasSize(1);
        assertThat(activeSuperUsers).extracting("active").containsOnly(true);
        assertThat(activeSuperUsers).extracting("superuser").containsOnly(true);

    }

}