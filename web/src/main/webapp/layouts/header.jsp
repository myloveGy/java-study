<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: jinxing
  Date: 2021/5/25
  Time: 9:54 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Java Study WEB JSP</title>
    <style>
        .header {
            background-color: #f8f8f8;
            border-color: #e7e7e7;
            height: 50px;
            border-bottom: 1px solid #e7e7e7;
        }

        .header > ul.nav, .header > ul.nav > li, .header > ul.nav > li > a {
            height: 50px;
            color: #777;
        }

        .header > ul.nav > li > a {
            line-height: 30px;
        }

        ul.nav-pills > li.active > a,
        ul.nav-pills > li.active > a:hover,
        ul.nav-pills > li.active > a:focus,
        ul.nav-pills > li > a:hover,
        ul.nav-pills > li > a:focus {
            text-decoration: none;
            background-color: #eee;
            color: #000000;
        }

        #content, .header > ul.nav {
            width: 1170px;
            margin: 0 auto;
        }

        #content {
            margin-top: 24px;
        }
    </style>
    <link rel="stylesheet" href="${ pageContext.request.contextPath }/assets/css/bootstrap.min.css"
          crossorigin="anonymous">
</head>
<body>
<div class="header">
    <%
        class Menu {
            public String url;
            public String name;

            public Menu(String url, String name) {
                this.url = url;
                this.name = name;
            }
        }

        List<Menu> menus = new ArrayList<>();

        menus.add(new Menu("/web/user/login.jsp", "Login"));
        menus.add(new Menu("/web/user/register.jsp", "Register"));
        menus.add(new Menu("/web/hello.jsp", "Hello"));
        menus.add(new Menu("/web/upload.jsp", "Upload"));
        menus.add(new Menu("/web/download", "文件下载"));
        menus.add(new Menu("/web/cookie", "Cookie"));
        menus.add(new Menu("/web/cookie.jsp", "查看Cookie"));

        // 需要判断登录验证
        if (request.getSession().getAttribute("username") != null) {
            menus.add(new Menu("/web/admin/session.jsp", "Session"));
            menus.add(new Menu("/web/admin/index.jsp", "管理员信息"));
        }

        // servlet
        List<Menu> servlet = new ArrayList<>();
        servlet.add(new Menu("/web/hello-servlet", "Hello Servlet"));
        servlet.add(new Menu("/web/context-servlet", "Context Servlet"));
        servlet.add(new Menu("/web/first-servlet", "First Servlet"));
        servlet.add(new Menu("/web/test-servlet", "Test Servlet"));

    %>
    <ul class="nav nav-pills">
        <li>
            <a href="/web">首页</a>
        </li>
        <li role="presentation" class="dropdown">
            <a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true"
               aria-expanded="false">
                servlet <span class="caret"></span>
            </a>
            <ul class="dropdown-menu">
                <% for (Menu m : servlet) { %>
                <li><a href="<%=m.url%>"><%=m.name%>
                </a></li>
                <% } %>
            </ul>
        </li>
        <% for (Menu m : menus) { %>
        <li <%=m.url.equals(new String(request.getRequestURI())) ? "class='active'" : ""%>><a
                href="<%=m.url%>"><%=m.name%>
        </a></li>
        <% } %>
    </ul>
</div>

