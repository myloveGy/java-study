<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="layouts/header.jsp" %>
<div id="content">
    <% request.setAttribute("username", "jinxing.liu"); %>
    表达式输出 username 的值: <%=request.getAttribute("username")%><br/>
    EL 表达式输出 username 的值: ${username}

    ${12 + 12}
    ${18 div 2}
</div>
<%@ include file="layouts/footer.jsp" %>