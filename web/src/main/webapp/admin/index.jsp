<%--
  Created by IntelliJ IDEA.
  User: jinxing
  Date: 2021/5/24
  Time: 4:59 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/layouts/header.jsp"/>
<style>
    #content div {
        margin-top: 20px;
        margin-bottom: 20px;
    }

    button {
        padding: 5px 10px;
    }
</style>
<div id="content">
    <div>登录用户名称: ${sessionScope.get("username")}</div>
    <div>登录用户密码: ${sessionScope.get("password")}</div>
    <form action="/web/session" method="post">
        <button type="submit">退出登录</button>
    </form>
</div>
<jsp:include page="/layouts/footer.jsp"/>
