<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="layouts/header.jsp" %>
<div id="content">
    <form action="/web/upload" method="post" enctype="multipart/form-data">
        <label for="username">
            用户名称
            <input type="text" name="username" id="username"/>
        </label>
        <label for="email">
            用户邮箱
            <input type="text" name="email" id="email"/>
        </label>
        <input type="file" name="avatar"/>
        <button type="submit">上传</button>
    </form>
</div>
<%@ include file="layouts/footer.jsp" %>