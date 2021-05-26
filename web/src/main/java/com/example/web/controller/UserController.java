package com.example.web.controller;

import com.example.web.pojo.User;
import com.example.web.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name="userController", value = "/user")
public class UserController extends HttpServlet {

    private UserService userService = new UserService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取请求参数
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // 实例化对象
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        try {
            // 执行登录
            userService.login(user);
            // 登录成功，设置session
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            session.setAttribute("password", password);
            response.sendRedirect("/web/admin/index.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            // 跳转方式
//            response.setStatus(302);
//            response.setHeader("Location", "/web/user/login.jsp");
            response.sendRedirect("/web/user/login.jsp");
        }
    }
}
