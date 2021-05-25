package com.example.web.controller;

import com.example.web.pojo.User;
import com.example.web.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="userController", value = "/user")
public class UserController extends HttpServlet {

    private UserService userService = new UserService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        try {
            userService.login(user);
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("登录成功");
        } catch (Exception e) {
            e.printStackTrace();
            // 跳转方式
//            response.setStatus(302);
//            response.setHeader("Location", "/web/user/login.jsp");
            response.sendRedirect("/web/user/login.jsp");
        }
    }
}
