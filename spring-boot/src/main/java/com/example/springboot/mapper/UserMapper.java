package com.example.springboot.mapper;

import com.example.springboot.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

public interface UserMapper {

    @Insert("INSERT INTO `mybatis_user` (`username`, `password`, `created_at`, `updated_at`) VALUES (#{username}, #{password}, #{createdAt}, #{updatedAt})")
    Integer insert(User user);

    @Update("UPDATE `mybatis_user` SET `username` = #{username}, `updated_at` = #{updatedAt} WHERE `user_id` = #{userId}")
    Integer update(User user);
}
