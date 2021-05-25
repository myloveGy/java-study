package com.example.web.dao;

import com.example.web.pojo.User;

public class UserDao extends BaseDao {

    public User queryUserByUsername(String username) {
        String sql = "SELECT *, `created_at` AS `createdAt` FROM `book_user` WHERE `username` = ?";
        return one(User.class, sql, username);
    }

    public User queryUserByUsernameAndPassword(String username, String password) {
        String sql = "SELECT *, `created_at` AS `createdAt` FROM `book_user` WHERE `username` = ? AND `password` = ?";
        return one(User.class, sql, username, password);
    }

    public int createUser(User user) {
        String sql = "INSERT INTO `book_user` (`username`, `password`, `email`, `status`, `created_at`) VALUES (?, ?, ?, ?, ?)";
        return update(sql, user.getUsername(), user.getPassword(), user.getEmail(), user.getStatus(), user.getCreatedAt());
    }
}
