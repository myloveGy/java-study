package com.study.my.mapper;

import com.study.my.domain.MyBatisUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MyBatisUserMapper {

    @Select("SELECT * FROM `mybatis_user`")
    @Results({
            @Result(column = "user_id", property = "userId"),
            @Result(column = "created_at", property = "createdAt"),
            @Result(column = "updated_at", property = "updatedAt"),
    })
    List<MyBatisUser> findAll();

    @Insert("INSERT INTO `mybatis_user` (`username`, `password`, `created_at`, `updated_at`) VALUES (#{username}, #{password}, #{createdAt}, #{updatedAt})")
    Integer insert(MyBatisUser user);
}
