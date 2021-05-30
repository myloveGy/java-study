package com.example.springboot.pojo;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "mybatis_user")
public class MyBatisUser {
    @Id
    @KeySql(useGeneratedKeys = true)
    @Column(name = "user_id")
    private Integer userId;
    private String username;
    private String password;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;
}
