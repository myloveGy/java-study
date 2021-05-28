package org.example.mapper;

import org.apache.ibatis.annotations.*;
import org.example.domain.Order;
import org.example.domain.User;

import java.util.List;

public interface User1Mapper {

    @Insert("INSERT INTO `mybatis_user` (`username`, `password`, `created_at`, `updated_at`) VALUES (#{username}, #{password}, #{createdAt}, #{updatedAt})")
    Integer insert(User user);

    @Update("UPDATE `mybatis_user` SET `username` = #{username}, `password` = #{password}, `updated_at` = #{updatedAt} WHERE `user_id` = #{userId}")
    Integer update(User user);

    @Delete("DELETE FROM `mybatis_user` WHERE `user_id` = #{userId}")
    Integer delete(Integer userId);

    @Select("SELECT * FROM `mybatis_user` WHERE `user_id` = #{userId}")
    @Results({
            @Result(column = "user_id", property = "userId"),
            @Result(column = "created_at", property = "createdAt"),
            @Result(column = "updated_at", property = "updatedAt")
    })
    User findById(Integer userId);

    @Select("SELECT * FROM `mybatis_user` WHERE `user_id` = #{userId}")
    @Results({
            @Result(column = "user_id", property = "userId"),
            @Result(column = "created_at", property = "createdAt"),
            @Result(column = "updated_at", property = "updatedAt"),
            @Result(
                    property = "orders",
                    column = "user_id",
                    javaType = List.class,
                    many = @Many(select = "org.example.mapper.Order1Mapper.findByUserId")
            )
    })
    User findOrderById(Integer userId);

    @Select("SELECT * FROM `mybatis_user` WHERE `user_id` = #{userId}")
    @Results({
            @Result(id = true, column = "user_id", property = "userId"),
            @Result(column = "created_at", property = "createdAt"),
            @Result(column = "updated_at", property = "updatedAt"),
            @Result(
                    property = "roles",
                    column = "user_id",
                    javaType = List.class,
                    many = @Many(select = "org.example.mapper.RoleMapper.findByUserId")
            )
    })
    User findRoleById(Integer userId);
}
