package org.example.mapper;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.example.domain.Order;
import org.example.domain.User;

import java.util.List;

public interface Order1Mapper {

    @Select("SELECT *, `mybatis_user`.`created_at` AS `u_created_at`, `mybatis_user`.`updated_at` AS `u_updated_at`, `mybatis_order`.`created_at` AS `o_created_at`, `mybatis_order`.`updated_at` AS `o_updated_at` FROM `mybatis_order`, `mybatis_user` WHERE `mybatis_order`.`user_id` = `mybatis_user`.`user_id`")
    @Results({
            @Result(column = "order_id", property = "orderId"),
            @Result(column = "order_sn", property = "orderSn"),
            @Result(column = "user_id", property = "userId"),
            @Result(column = "o_created_at", property = "createdAt"),
            @Result(column = "o_updated_at", property = "updatedAt"),
            @Result(column = "user_id", property = "user.userId"),
            @Result(column = "username", property = "user.username"),
            @Result(column = "password", property = "user.password"),
            @Result(column = "u_created_at", property = "user.createdAt"),
            @Result(column = "u_updated_at", property = "user.updatedAt")
    })
    List<Order> findAll();

    @Select("SELECT * FROM `mybatis_order` WHERE `order_id` = #{orderId}")
    @Results({
            @Result(column = "order_id", property = "orderId"),
            @Result(column = "order_sn", property = "orderSn"),
            @Result(column = "user_id", property = "userId"),
            @Result(column = "created_at", property = "createdAt"),
            @Result(column = "updated_at", property = "updatedAt"),
            @Result(
                    property = "user", // 需要封装的属性名称
                    column = "user_id", // 关联字段名称(那个字段去查询user表的数据)
                    javaType = User.class, // 需要封装的类型
                    // select 属性代表查询那个接口的方法获取数
                    one = @One(select = "org.example.mapper.User1Mapper.findById")
            )
    })
    Order findByOrderId(Integer orderId);

    @Select("SELECT * FROM `mybatis_order` WHERE `user_id` = #{userId}")
    @Results({
            @Result(column = "order_id", property = "orderId"),
            @Result(column = "order_sn", property = "orderSn"),
            @Result(column = "user_id", property = "userId"),
            @Result(column = "created_at", property = "createdAt"),
            @Result(column = "updated_at", property = "updatedAt")
    })
    List<Order> findByUserId(Integer userId);
}
