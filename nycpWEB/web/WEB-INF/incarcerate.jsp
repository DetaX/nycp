<%-- 
    Document   : incarcerate
    Created on : Oct 20, 2014, 5:58:38 PM
    Author     : zex
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%= request.getAttribute("test") %>
        <form action="newjsp.jsp" method="POST">
            <input type="text" id="name" name="name"/>
            <input type="submit" id="submit"/>
        </form>
    </body>
   <%-- <jsp:include page="NewServlet"/>--%>
</html>
