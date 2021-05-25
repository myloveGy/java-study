package com.example.web.service;

import com.example.web.pojo.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceTest {

    @Test
    public void login() {
        User user = new User();
        user.setUsername("jinxing");
        user.setPassword("123456");
        try {
            User loginUser = new UserService().login(user);
            assertNotNull(loginUser);
            assertEquals("jinxing", loginUser.getUsername());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}