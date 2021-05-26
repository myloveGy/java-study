<%@ page import="java.util.Enumeration" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../layouts/header.jsp" %>
<div id="content">
    <table class="table table-bordered table-hover">
        <thead>
        <tr>
            <th>Name</th>
            <th>Value</th>
        </tr>
        </thead>
        <tbody>
        <%
            HttpSession session1 = request.getSession();
            Enumeration<String> attributeNames = session1.getAttributeNames();
            while (attributeNames.hasMoreElements()) {
                String name = attributeNames.nextElement();
        %>
        <tr>
            <td>
                <%=name%>
            </td>
            <td>
                <%=session1.getAttribute(name)%>
            </td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
</div>
<%@ include file="../layouts/footer.jsp" %>