<%--
  Created by IntelliJ IDEA.
  User: jinxing
  Date: 2021/5/24
  Time: 6:10 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/layouts/header.jsp"/>
<div id="content">
    <div style="margin: 20px auto;border: 1px solid orange;text-align: center; padding: 20px">
        pageContext 域是否有值: <%=pageContext.getAttribute("key")%><br/>
        request 域是否有值: <%=request.getAttribute("key")%><br/>
        session 域是否有值: <%=session.getAttribute("key")%><br/>
        application 域是否有值: <%=application.getAttribute("key")%><br/>
    </div>
</div>
<jsp:include page="/layouts/footer.jsp"/>
