package com.study.my.service;

import com.study.my.dao.UserDao;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component("userService")
public class UserService {

    @Resource(name = "userDao")
    private UserDao userDao;

    public void save() {
        userDao.save();
    }
}
