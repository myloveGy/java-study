<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="layouts/header.jsp" %>
<div id="content">
    <table class="table table-bordered table-hover">
        <tr>
            <th>Name</th>
            <th>Value</th>
            <th>Domain</th>
            <th>Path</th>
        </tr>
        <%
            Cookie[] cookies = request.getCookies();
            for (int i = 0; i < cookies.length; i++) {
        %>
        <tr>
            <td>
                <%=cookies[i].getName()%>
            </td>
            <td>
                <%=cookies[i].getValue()%>
            </td>
            <td>
                <%=cookies[i].getDomain()%>
            </td>
            <td>
                <%=cookies[i].getPath()%>
            </td>
        </tr>
        <%
            }
        %>

    </table>
</div>
<%@ include file="layouts/footer.jsp" %>