package com.example.web.dao;

import com.example.web.pojo.User;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.Assert.*;

public class UserDaoTest {

    @Test
    public void queryUserByUsername() {
        User user = new UserDao().queryUserByUsername("jinxing.liu");
        assertNull(user);

        System.out.println(new UserDao().queryUserByUsername("jinxing"));
    }

    @Test
    public void queryUserByUsernameAndPassword() {
        User user = new UserDao().queryUserByUsernameAndPassword("jinxing.liu", "123456");
        assertNull(user);
    }

    @Test
    public void createUser() {
        User user = new User();
        user.setEmail("821901008@qq.com");
        user.setUsername("jinxing");
        user.setPassword("123456");
        user.setCreatedAt(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        assertTrue(new UserDao().createUser(user) > 0);
    }
}