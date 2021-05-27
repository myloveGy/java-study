<%--
  Created by IntelliJ IDEA.
  User: jinxing
  Date: 2021/5/20
  Time: 4:21 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:include page="/layouts/header.jsp"/>
<style>
    h4 > span {
        font-size: 16px;
    }
</style>
<div id="content">
    <h1> 解析请求参数 </h1>

    <div class="panel panel-default">
        <div class="panel-heading">
            <h4> 将请求参数解析到变量 <span>${pageContext.request.contextPath}/request</span></h4>
        </div>
        <div class="panel-body">
            <div class="row">
                <div class="col-md-6">
                    <form action="${pageContext.request.contextPath}/request" method="post" data-pre="request">
                        <div class="form-group">
                            <label for="name">Name</label>
                            <input type="text" name="name" class="form-control" id="name">
                        </div>
                        <div class="form-group">
                            <label for="age-request">Age</label>
                            <input type="text" name="age" class="form-control" id="age-request">
                        </div>
                        <button type="submit" class="btn btn-default">Submit</button>
                    </form>
                </div>
                <div class="col-md-6">
                    <h4>响应内容</h4>
                    <pre id="request"></pre>
                </div>
            </div>
        </div>
    </div>

    <div class="panel panel-default">
        <div class="panel-heading">
            <h4> 将请求参数解析到对象 <span>${pageContext.request.contextPath}/request1</span></h4>
        </div>
        <div class="panel-body">
            <div class="row">
                <div class="col-md-6">
                    <form action="${pageContext.request.contextPath}/request1" method="post" data-pre="request1">
                        <div class="form-group">
                            <label for="username-request1">Username</label>
                            <input type="text" name="username" class="form-control" id="username-request1">
                        </div>
                        <div class="form-group">
                            <label for="age-request1">Age</label>
                            <input type="text" name="age" class="form-control" id="age-request1">
                        </div>
                        <button type="submit" class="btn btn-default">Submit</button>
                    </form>
                </div>
                <div class="col-md-6">
                    <h4>响应内容</h4>
                    <pre id="request1"></pre>
                </div>
            </div>
        </div>
    </div>

    <div class="panel panel-default">
        <div class="panel-heading">
            <h4> 解析List请求参数 <span>${pageContext.request.contextPath}/request2</span></h4>
        </div>
        <div class="panel-body">
            <div class="row">
                <div class="col-md-6">
                    <form action="${pageContext.request.contextPath}/request2" method="post" id="form"
                          data-pre="request2">
                        <div class="form-group">
                            <label for="username">Username</label>
                            <input type="text" name="userList[0].username" class="form-control" id="username">
                        </div>
                        <div class="form-group">
                            <label for="age">Age</label>
                            <input type="text" name="userList[0].age" class="form-control" id="age">
                        </div>
                        <div class="form-group">
                            <label for="username">Username1</label>
                            <input type="text" name="userList[1].username" class="form-control" id="username1">
                        </div>
                        <div class="form-group">
                            <label for="age">Age1</label>
                            <input type="text" name="userList[1].age" class="form-control" id="age1">
                        </div>
                        <button type="submit" class="btn btn-default">Submit</button>
                    </form>
                </div>
                <div class="col-md-6">
                    <h4>响应内容</h4>
                    <pre id="request2"></pre>
                </div>
            </div>
        </div>
    </div>

    <div class="panel panel-default">
        <div class="panel-heading">
            <h4> 请求参数解析到变量 @RequestParam 注解使用 <span>${pageContext.request.contextPath}/request3</span></h4>
        </div>
        <div class="panel-body">
            <div class="row">
                <div class="col-md-6">
                    <form action="${pageContext.request.contextPath}/request3" method="post" data-pre="request3">
                        <div class="form-group">
                            <label for="exampleInputName2">Name</label>
                            <input type="text" class="form-control" name="username" id="exampleInputName2" placeholder="Jane Doe">
                        </div>
                        <div class="form-group">
                            <label for="exampleInputEmail2">Email</label>
                            <input type="email" class="form-control" name="email" id="exampleInputEmail2"
                                   placeholder="jane.doe@example.com">
                        </div>
                        <button type="submit" class="btn btn-default">Send invitation</button>
                    </form>
                </div>
                <div class="col-md-6">
                    <h4>响应内容</h4>
                    <pre id="request3"></pre>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    $("form").submit(function () {
        let pre = $(this).data("pre")
        console.info(pre)
        $.ajax({
            url: $(this).attr("action"),
            data: $(this).serialize(),
            type: "POST",
            dataType: "json"
        }).done(function (data) {
            $("#" + pre).html(JSON.stringify(data, null, 4))
        })

        return false;
    })
</script>
<jsp:include page="/layouts/footer.jsp"/>
