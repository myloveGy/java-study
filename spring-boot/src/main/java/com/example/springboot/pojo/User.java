package com.example.springboot.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private Integer userId;
    private String username;
    private String password;
    private Date createdAt;
    private Date updatedAt;
}
