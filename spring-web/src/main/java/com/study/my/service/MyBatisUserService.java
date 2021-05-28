package com.study.my.service;

import com.study.my.domain.MyBatisUser;
import com.study.my.mapper.MyBatisUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("myBatisUserService")
public class MyBatisUserService {

    @Autowired
    private MyBatisUserMapper myBatisUserMapper;

    public Integer insert(MyBatisUser user) {
        return myBatisUserMapper.insert(user);
    }

    public List<MyBatisUser> findAll() {
        return myBatisUserMapper.findAll();
    }
}
