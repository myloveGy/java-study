package com.example.springboot.service;

import com.example.springboot.mapper.MyBatisUserMapper;
import com.example.springboot.pojo.MyBatisUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyBatisUserService {

    @Autowired
    private MyBatisUserMapper myBatisUserMapper;

    public Integer insert(MyBatisUser user) {
        return myBatisUserMapper.insert(user);
    }

    public MyBatisUser findById(Integer userId) {
        return myBatisUserMapper.selectByPrimaryKey(userId);
    }
}
