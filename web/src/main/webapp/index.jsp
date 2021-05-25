<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="layouts/header.jsp" %>
<style>
    table tr td {
        padding: 5px;
        border: 1px solid #000;
    }

    table {
        border-collapse: collapse;
    }
</style>
<div id="content">
    <table>
        <% for (int i = 1; i <= 9 ; i++) {
            out.println("<tr>");
            for (int j = 1; j <= i; j++) {
                out.println("<td>" + j + " x " + i + " = " + (i * j) +  "</td>");
            }
            out.println("</tr>");
        } %>
    </table>
</div>
<%@ include file="layouts/footer.jsp" %>