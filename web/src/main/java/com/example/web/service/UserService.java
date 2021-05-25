package com.example.web.service;

import com.example.web.dao.UserDao;
import com.example.web.pojo.User;

public class UserService {

    private final UserDao userDao = new UserDao();

    public void register(User user) {
        userDao.createUser(user);
    }

    public User login(User user) throws Exception {
        User loginUser = userDao.queryUserByUsernameAndPassword(user.getUsername(), user.getPassword());
        if (loginUser == null) {
            throw new Exception("登录用户名称获取密码错误");
        }

        // 验证用户状态
        if (loginUser.getStatus() != User.USER_STATUS) {
            throw new Exception("用户已经被停用");
        }

        return loginUser;
    }
}
