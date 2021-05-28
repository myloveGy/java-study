package org.example.mapper;

import org.example.domain.Order;

import java.util.List;

public interface OrderMapper {
    // 查询多个,带查询条件
    List<Order> findAll(Order order);

    // 查询单个
    Order findOne(Integer orderId);

    // 查询当个订单信息并且带用户信息
    Order findUserById(Integer orderId);
}
