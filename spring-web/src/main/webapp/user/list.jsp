<%@ page import="com.study.my.domain.MyBatisUser" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: jinxing
  Date: 2021/5/27
  Time: 10:25 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/layouts/header.jsp"/>
<div id="content">
    <h1>用户列表 <a href="${pageContext.request.contextPath}/user/create.jsp" class="btn btn-success">添加用户</a></h1>
    <table class="table table-bordered" style="margin-top: 24px">
        <thead>
        <tr>
            <th>用户ID</th>
            <th>用户名称</th>
            <th>用户密码</th>
            <th>创建时间</th>
            <th>修改时间</th>
        </tr>
        </thead>
        <tbody>
        <%
            List<MyBatisUser> list = (List<MyBatisUser>) request.getAttribute("list");
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            for (MyBatisUser myBatisUser : list) {
        %>

        <tr>
            <td><%=myBatisUser.getUserId()%>
            </td>
            <td><%=myBatisUser.getUsername()%>
            </td>
            <td><%=myBatisUser.getPassword()%>
            </td>
            <td><%=format.format(myBatisUser.getCreatedAt())%>
            </td>
            <td><%=format.format(myBatisUser.getUpdatedAt())%>
            </td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
</div>
<jsp:include page="/layouts/footer.jsp"/>
