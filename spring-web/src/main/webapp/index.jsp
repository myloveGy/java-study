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
    <h1>Spring Web MVC ${username}</h1>

    <div>
        <form action="${pageContext.request.contextPath}/request2" method="post" id="form">
            <input type="text" name="userList[0].username">
            <input type="text" name="userList[0].age">
            <input type="text" name="userList[1].username">
            <input type="text" name="userList[1].age">
            <button type="submit">
                提交
            </button>
        </form>
    </div>


    <div>
        <h3>URL: ${pageContext.request.contextPath}/request3</h3>
        <form class="form-inline" action="${pageContext.request.contextPath}/request3" method="post">
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
</div>
<script>
    $("form").submit(function () {
        $.ajax({
            url: $(this).attr("action"),
            data: $(this).serialize(),
            type: "POST",
            dataType: "json"
        }).done(function (data) {
            alert(JSON.stringify(data))
        })

        return false;
    })
</script>
<jsp:include page="/layouts/footer.jsp"/>
