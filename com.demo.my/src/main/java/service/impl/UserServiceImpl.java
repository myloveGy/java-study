package service.impl;

import dao.UserDao;
import service.UserService;


public class UserServiceImpl implements UserService {
    private UserDao userDao;

    @Override
    public void save() {
        this.userDao.save();
    }
}
