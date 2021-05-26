package com.study.my.web;

import com.study.my.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserServlet extends HttpServlet {

    // 自定义方式处理
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
////        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
//        ApplicationContext app = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
//        UserService userService = app.getBean(UserService.class);
//        userService.save();
//    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ApplicationContext app = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
        UserService userService = app.getBean(UserService.class);
        userService.save();
    }
}
