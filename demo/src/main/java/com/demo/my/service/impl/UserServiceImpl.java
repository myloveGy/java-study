package com.demo.my.service.impl;

import com.demo.my.dao.UserDao;
import org.springframework.stereotype.Service;
import com.demo.my.service.UserService;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource(name = "userDao")
    private UserDao userDao;

    @Override
    public void save() {
        this.userDao.save();
    }

    @PostConstruct
    public void init() {
        System.out.println("初始化操作...");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("销毁操作...");
    }
}
