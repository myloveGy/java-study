package com.example.web.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SessionController", value = "/session")
public class SessionController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        session.setAttribute("username", "jinxing.liu");
        session.setAttribute("password", "123456");

        // 响应JSON
        response.setContentType("application/json; charset=UTF-8");
        response.getWriter().write("{\"status\": 200, \"msg\":\"success\"}");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        // 清除SESSION
        session.removeAttribute("username");
        session.removeAttribute("password");

        // 执行跳转
        response.sendRedirect("/web/user/login.jsp");
    }
}
