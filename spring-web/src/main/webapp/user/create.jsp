<%--
  Created by IntelliJ IDEA.
  User: jinxing
  Date: 2021/5/27
  Time: 10:25 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/layouts/header.jsp"/>
<div id="content">
    <h1>添加用户信息</h1>
    <form action="${pageContext.request.contextPath}/user/create" method="post">
        <div class="form-group">
            <label for="username">用户名称</label>
            <input type="text"
                   name="username"
                   class="form-control"
                   id="username"
                   placeholder="请输入用户名称">
        </div>
        <div class="form-group">
            <label for="password">用户密码</label>
            <input type="password"
                   name="password"
                   class="form-control"
                   id="password"
                   placeholder="请输入密码"
                   autocomplete="off"
                   readonly
                   onfocus="this.removeAttribute('readonly')"
                   onblur="this.removeAttribute('readonly')"
                   onclick="this.removeAttribute('readonly')"
            >
        </div>
        <button type="submit" class="btn btn-default">确认添加</button>
    </form>
</div>
<jsp:include page="/layouts/footer.jsp"/>
