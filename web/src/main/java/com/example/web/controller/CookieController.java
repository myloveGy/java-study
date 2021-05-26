package com.example.web.controller;


import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "CookieController", value = "/cookie")
public class CookieController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("jinxing.liu CookieServlet");
        // 1、创建cookie对象
        Cookie cookie = new Cookie("username", "jinxing.liu");
        response.addCookie(cookie);
        response.setContentType("application/json; charset=utf-8");
        response.getWriter().write("{\"code\": 200, \"msg\": \"success\", \"data\": {\"cookies\": \""+ Arrays.toString(request.getCookies()) +"\"}}");
    }
}
