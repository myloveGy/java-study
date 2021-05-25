<%--
  Created by IntelliJ IDEA.
  User: jinxing
  Date: 2021/5/24
  Time: 4:59 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/layouts/header.jsp"/>
<div id="content">
    <form action="/web/user" method="post">
        <label for="username">
            用户名称
            <input type="text" name="username" id="username"/>
        </label>
        <label for="password">
            用户密码
            <input type="password" name="password" id="password"/>
        </label>
        <button type="submit">登录</button>
        <%=request.getParameter("username")%>

        <div style="margin: 20px auto;border: 1px solid orange;text-align: center">
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
    </form>
</div>
<jsp:include page="/layouts/footer.jsp"/>
