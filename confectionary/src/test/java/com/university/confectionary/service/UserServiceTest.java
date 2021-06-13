package com.university.confectionary.service;

import junit.framework.TestCase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.*;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    public UserService userService;

    @Test
    public void testCreateUser() {
        assertTrue(userService.createUser("Alice","aCDSAdecaw2e3w"));
    }
}