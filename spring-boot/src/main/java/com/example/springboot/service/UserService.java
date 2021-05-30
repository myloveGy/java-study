package com.example.springboot.service;

import com.example.springboot.pojo.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    public User queryById(Long id) {
        return new User();
    }

    @Transactional
    public void saveUser(User user) {
        System.out.println("新增用户");
    }
}
