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
    <h1>文件上传</h1>

    <div class="panel panel-default">
        <div class="panel-heading">
            <h4> 文件上传 <span>${pageContext.request.contextPath}/upload</span></h4>
        </div>
        <div class="panel-body">
            <form action="${pageContext.request.contextPath}/upload" method="post" enctype="multipart/form-data">
                <div class="form-group">
                    <label for="exampleInputEmail1">Email address</label>
                    <input type="email" name="email" class="form-control" id="exampleInputEmail1" placeholder="Email">
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1">Username</label>
                    <input type="text" name="username" class="form-control" id="exampleInputPassword1"
                           placeholder="Password">
                </div>
                <div class="form-group">
                    <label for="exampleInputFile">File input</label>
                    <input type="file" name="file" id="exampleInputFile">
                    <p class="help-block">Example block-level help text here.</p>
                </div>
                <button type="submit" class="btn btn-default">Submit</button>
            </form>
        </div>
    </div>

</div>
<jsp:include page="/layouts/footer.jsp"/>
