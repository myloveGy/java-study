<%--
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
        body, * {
            margin: 0;
            padding: 0;
        }

        .header ul {
            list-style: none;
        }

        .header ul li {
            display: inline-block;
        }

        .header ul li a {
            padding: 5px;
            text-decoration: none;
            display: block;
            line-height: 40px;
            color: #777;
        }

        .header ul li a:hover {
            color: #333;
        }

        .header {
            background-color: #f8f8f8;
            border-color: #e7e7e7;
            height: 50px;
            border-bottom: 1px solid #e7e7e7;
        }


        #content, .header ul {
            width: 1170px;
            margin: 0 auto;
        }

        #content {
            margin-top: 24px;
        }
    </style>
</head>
<body>
<div class="header">
    <ul>
        <li><a href="/web">首页</a></li>
        <li><a href="/web/hello-servlet">Hello Servlet</a></li>
        <li><a href="/web/first-servlet">First Servlet</a></li>
        <li><a href="/web/test-servlet">Test Servlet</a></li>
        <li><a href="/web/user/login.jsp">Login</a></li>
        <li><a href="/web/user/register.jsp">Register</a></li>
    </ul>
</div>

