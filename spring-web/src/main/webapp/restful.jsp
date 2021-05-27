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
    #left-content {
        display: flex;
    }
    #left-content>button {
        display: inline-block;
    }
</style>
<div id="content">
    <h1>Restful 动态路由</h1>

    <div class="panel panel-default">
        <div class="panel-heading">
            <h4> Result 动态路由 <span>${pageContext.request.contextPath}/restful/{name}</span></h4>
        </div>
        <div class="panel-body">
            <div class="row">
                <div class="col-md-6">
                    <div id="left-content">
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
                            <input type="text" class="form-control" aria-label="...">
                        </div>
                        <button type="submit" class="btn btn-success">提交</button>
                    </div>

                </div>
                <div class="col-md-6">
                    <h4>响应内容</h4>
                    <pre id="request3"></pre>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="/layouts/footer.jsp"/>
