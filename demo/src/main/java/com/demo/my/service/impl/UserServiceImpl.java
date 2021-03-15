package com.demo.my.service.impl;

import com.demo.my.dao.UserDao;
import org.springframework.stereotype.Service;
import com.demo.my.service.UserService;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource(name = "userDao")
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void save() {
        this.userDao.save();
    }
}
