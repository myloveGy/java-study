package org.example.mapper;

import org.example.domain.User;

import java.util.List;

public interface UserMapper {
    // 查询全部
    List<User> findAll();

    // 查询单个
    User findOne(Integer userId);

    // 查询多个并且带订单信息
    List<User> findOrderByUserId(Integer userId);
}
