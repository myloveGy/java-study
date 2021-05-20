package com.study.my.dao.impl;


import com.study.my.dao.UserDao;
import org.springframework.stereotype.Repository;

@Repository("userDao")
public class UserDaoImpl implements UserDao {
    public void save() {
        System.out.println("save running!");
    }
}
