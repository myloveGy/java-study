<%--
  Created by IntelliJ IDEA.
  User: jinxing
  Date: 2021/5/20
  Time: 4:21 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:include page="/layouts/header.jsp"/>
<div id="content">
    <div class="alert alert-success" role="alert">
        处理成功 <a href="${pageContext.request.contextPath}" class="alert-link">回到首页</a>
    </div>
</div>
<jsp:include page="/layouts/footer.jsp"/>
