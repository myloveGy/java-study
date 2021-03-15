package com.demo.my.dao.impl;

import com.demo.my.dao.UserDao;
import org.springframework.stereotype.Repository;

@Repository("userDao")
public class UserDaoImpl implements UserDao {
    @Override
    public void save() {
        System.out.println("my running...");
    }
}
