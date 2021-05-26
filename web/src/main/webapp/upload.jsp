<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="layouts/header.jsp" %>
<div id="content">
    <form action="/web/upload" method="post" enctype="multipart/form-data">
        <div class="form-group">
            <label for="username">用户名称</label>
            <input type="username" name="username" class="form-control" id="username" placeholder="username">
        </div>
        <div class="form-group">
            <label for="email">用户邮箱</label>
            <input type="email" name="email" class="form-control" id="email" placeholder="email">
        </div>
        <div class="form-group">
            <label for="exampleInputFile">上传文件</label>
            <input type="file" name="file" id="exampleInputFile">
            <p class="help-block">请上传图片文件(jpg、jpeg、png、gif)</p>
        </div>
        <button type="submit" class="btn btn-default">上传文件</button>
    </form>
</div>
<%@ include file="layouts/footer.jsp" %>