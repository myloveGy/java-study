<%--
  Created by IntelliJ IDEA.
  User: jinxing
  Date: 2021/5/27
  Time: 10:25 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/layouts/header.jsp"/>
<style>
    .left-content {
        display: flex;
    }
    .left-content>button {
        display: inline-block;
    }
</style>
<div id="content">
    <h1>Restful 动态路由</h1>

    <div class="panel panel-default">
        <div class="panel-heading">
            <h4> Result 动态路由(@PathVariable 注解)<span>${pageContext.request.contextPath}/restful/{name}</span></h4>
        </div>
        <div class="panel-body">
            <div class="row">
                <div class="col-md-6">
                    <div class="left-content">
                        <div class="input-group">
                            <div class="input-group-btn">
                                <div class="btn-group">
                                    <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown"
                                            aria-haspopup="true" aria-expanded="false">
                                        路由名称 <span class="caret"></span>
                                    </button>
                                    <ul class="dropdown-menu">
                                        <li><a href="#">路由名称</a></li>
                                        <li><a href="#">Another action</a></li>
                                        <li><a href="#">Something else here</a></li>
                                        <li role="separator" class="divider"></li>
                                        <li><a href="#">Separated link</a></li>
                                    </ul>
                                </div>
                            </div>
                            <input type="text" class="form-control" id="input">
                        </div>
                        <button
                                type="button"
                                class="btn btn-success"
                                data-input="input"
                                data-url="${pageContext.request.contextPath}/restful/"
                                data-response="response"
                        >提交</button>
                    </div>

                </div>
                <div class="col-md-6">
                    <h4>响应内容</h4>
                    <pre id="response"></pre>
                </div>
            </div>
        </div>
    </div>

    <div class="panel panel-default">
        <div class="panel-heading">
            <h4> 自定义类型转换器 <span>${pageContext.request.contextPath}/restful/custom</span></h4>
        </div>
        <div class="panel-body">
            <div class="row">
                <div class="col-md-6">
                    <div class="left-content">
                        <div class="input-group">
                            <div class="input-group-btn">
                                <div class="btn-group">
                                    <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown"
                                            aria-haspopup="true" aria-expanded="false">
                                        路由名称 <span class="caret"></span>
                                    </button>
                                    <ul class="dropdown-menu">
                                        <li><a href="#">路由名称</a></li>
                                        <li><a href="#">Another action</a></li>
                                        <li><a href="#">Something else here</a></li>
                                        <li role="separator" class="divider"></li>
                                        <li><a href="#">Separated link</a></li>
                                    </ul>
                                </div>
                            </div>
                            <input type="text" class="form-control" id="input1">
                        </div>
                        <button
                                type="button"
                                class="btn btn-success"
                                data-input="input1"
                                data-url="${pageContext.request.contextPath}/restful/custom?date="
                                data-response="response1"
                        >提交</button>
                    </div>

                </div>
                <div class="col-md-6">
                    <h4>响应内容</h4>
                    <pre id="response1"></pre>
                </div>
            </div>
        </div>
    </div>

    <div class="panel panel-default">
        <div class="panel-heading">
            <h4> 获取Header&Cookie <span>${pageContext.request.contextPath}/restful/header</span></h4>
        </div>
        <div class="panel-body">
            <div class="row">
                <div class="col-md-6">
                    <div class="left-content">
                        <div class="input-group">
                            <div class="input-group-btn">
                                <div class="btn-group">
                                    <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown"
                                            aria-haspopup="true" aria-expanded="false">
                                        路由名称 <span class="caret"></span>
                                    </button>
                                    <ul class="dropdown-menu">
                                        <li><a href="#">路由名称</a></li>
                                        <li><a href="#">Another action</a></li>
                                        <li><a href="#">Something else here</a></li>
                                        <li role="separator" class="divider"></li>
                                        <li><a href="#">Separated link</a></li>
                                    </ul>
                                </div>
                            </div>
                            <input type="text" class="form-control" id="input2" value="header" readonly>
                        </div>
                        <button
                                type="button"
                                class="btn btn-success"
                                data-input="input2"
                                data-url="${pageContext.request.contextPath}/restful/"
                                data-response="response2"
                        >提交</button>
                    </div>

                </div>
                <div class="col-md-6">
                    <h4>响应内容</h4>
                    <pre id="response2"></pre>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    $("button").click(function () {
        let input = $("#" + $(this).data("input"))
        if (!input.val()) {
            alert("请输入内容提交")
            return false;
        }

        let response = $("#" + $(this).data("response"))
        $.ajax({
            url: $(this).data("url") + input.val(),
            data: $(this).serialize(),
            type: "POST",
            dataType: "json"
        }).done(function (data) {
            response.html(JSON.stringify(data, null, 4))
        })

        return false;
    })
</script>
<jsp:include page="/layouts/footer.jsp"/>
