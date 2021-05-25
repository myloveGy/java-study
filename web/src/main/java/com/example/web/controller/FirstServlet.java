package com.example.web.controller;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;

public class FirstServlet implements Servlet {

    private ServletConfig servletConfig;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        this.servletConfig = servletConfig;
    }

    @Override
    public ServletConfig getServletConfig() {
        return servletConfig;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        System.out.println(httpServletRequest.getMethod());
        System.out.println("First Servlet!");
        ServletConfig servletConfig = getServletConfig();
        System.out.println(servletConfig.getInitParameter("username"));
        System.out.println(servletConfig.getServletContext().getAttribute("username"));
        servletResponse.setContentType("application/json;charset=utf-8");
        PrintWriter writer = servletResponse.getWriter();
        writer.println("{\"code\": 200, \"message\": \"success\"}");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
