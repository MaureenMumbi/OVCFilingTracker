<%-- 
    Document   : logout
    Created on : Sep 30, 2014, 11:20:29 AM
    Author     : Maureen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
         session.invalidate();
            response.sendRedirect("index.jsp");%>
    </body>
</html>

