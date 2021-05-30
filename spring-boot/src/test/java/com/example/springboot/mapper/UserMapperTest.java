package com.example.springboot.mapper;

import com.example.springboot.pojo.User;
import com.example.springboot.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @Test
    void insert() {
        User user = new User();
        user.setUsername("spring-boot-test");
        user.setPassword("spring-boot-test");
        user.setCreatedAt(new Date());
        user.setUpdatedAt(new Date());
        userService.saveUser(user);
        System.out.println(userMapper.insert(user));
    }

    @Test
    void update() {
        User user = new User();
        user.setUsername("spring-boot-test123");
        user.setUpdatedAt(new Date());
        user.setUserId(20);
        System.out.println(userMapper.update(user));
    }
}