package com.demo.my.web;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.demo.my.service.UserService;

public class UserController {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) app.getBean("userService");
        userService.save();
    }
}
