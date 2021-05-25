package com.example.web.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "TestServlet", value = "/test-servlet")
public class TestServlet extends HttpServlet {

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        super.init(servletConfig);
        System.out.println(servletConfig.getServletName());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取请求路径
        System.out.println(request.getRequestURI());
        // 获取统一资源符
        System.out.println(request.getRequestURL());
        // 获取IP地址
        System.out.println(request.getRemoteHost());
        System.out.println(request.getHeader("User-Agent"));

        response.setContentType("application/json;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.write("{\"uri\": \"" + request.getRequestURI() + "\"}");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.write("{\"uri\": \"" + request.getRequestURI() + "\", \"post\": {\"username\": \"" + request.getParameter("username") + "\"}}");
    }
}
