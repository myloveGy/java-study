package com.example.web.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ContextServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = getServletConfig().getServletContext();
        // 获取参数
        System.out.println(context.getInitParameter("username"));

        // 获取路径(工程路径)
        System.out.println(context.getContextPath());

        // 获取工程部署路径
        System.out.println(context.getRealPath("/"));

        // 设置属性
        context.setAttribute("username", "jinxing.liu");

        System.out.println(context.getAttribute("username"));

        // 请求转发
        request.setAttribute("key", "柜台1的章");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/first-servlet");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
