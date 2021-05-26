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
    form label {
        display: block;
    }
</style>
<div id="content">
    <form action="/web/user" method="post">
        <div class="form-group">
            <label for="username">用户名称</label>
            <input type="text" class="form-control" id="username" name="username" placeholder="请输入用户名称">
        </div>
        <div class="form-group">
            <label for="password">用户密码</label>
            <input
                    type="password"
                    class="form-control"
                    id="password"
                    name="password"
                    placeholder="请输入用户密码"
                    autocomplete="off"
                    readonly
                    οnfοcus="this.removeAttribute('readonly')"
                    onblur="this.removeAttribute('readonly')"
                    onclick="this.removeAttribute('readonly')"
            >
        </div>
        <div class="form-group">
            <label for="captcha">验证码</label>
            <div style="display: flex">
                <input type="text" id="captcha" class="form-control" style="width: 200px">
                <img
                        src="/web/captcha.jpg"
                        alt="验证码"
                        onClick="this.src = '/web/captcha.jpg?t=' + (new Date()).getTime()"
                        style="height: 34px;"
                >
            </div>
            <p class="help-block">
                请输入验证码
            </p>
        </div>
        <button type="submit" class="btn btn-default">登录</button>
    </form>


    <div style="margin: 20px auto;border: 1px solid orange;text-align: center">
        <%=request.getParameter("username")%>
        <%
            pageContext.setAttribute("key", "pageContext");
            request.setAttribute("key", "request");
            session.setAttribute("key", "session");
            application.setAttribute("key", "application");
        %>

        pageContext 域是否有值: <%=pageContext.getAttribute("key")%><br/>
        request 域是否有值: <%=request.getAttribute("key")%><br/>
        session 域是否有值: <%=session.getAttribute("key")%><br/>
        application 域是否有值: <%=application.getAttribute("key")%><br/>
    </div>
</div>
<jsp:include page="/layouts/footer.jsp"/>
