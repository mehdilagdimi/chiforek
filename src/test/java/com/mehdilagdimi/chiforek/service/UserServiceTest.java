package com.mehdilagdimi.chiforek.service;

import com.mehdilagdimi.chiforek.base.Users;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {

    @Autowired
    UserService userService;

    @Test
    void whenApplicationStarts_thenHibernateCreatesInitialUserRecords() {
        List<Users> users = userService.list();
        assertEquals(3, users.size());
    }

}