package com.example.springboot.controller;

import com.example.springboot.pojo.MyBatisUser;
import com.example.springboot.service.MyBatisUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

@RestController
public class HelloController {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private MyBatisUserService myBatisUserService;

    @GetMapping("/hello")
    public String hello() {
        System.out.println(dataSource);
        return "Hello, Spring Boot!";
    }

    @GetMapping("/one/{id}")
    public MyBatisUser one(@PathVariable(name = "id") String userId) {
        return myBatisUserService.findById(Integer.valueOf(userId));
    }

}
