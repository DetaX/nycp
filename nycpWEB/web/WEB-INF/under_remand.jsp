<%-- 
    Document   : under_remand
    Created on : Oct 24, 2014, 12:19:57 PM
    Author     : DetaX
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Prisoners under remand</title>
    </head>
    <body>
        <h1>Prisoners under remand</h1>
        <a href="index.html">Home</a>
        <table>
    <tr>
    <th>prison file number</th>
    <th>given name</th>
    <th>surname</th>
    <th>date of birth</th>
    <th>place of birth</th>
    </tr>
            <c:forEach var="prisoner" items="${prisoners}">
                <tr>
                    <td>${prisoner[3]}</td>
                    <td>${prisoner[1]}</td>
                    <td>${prisoner[1]}</td>
                    <td>${prisoner[4]}</td>
                    <td>${prisoner[2]}</td>
                </tr>
             </c:forEach>
        </table>
    </body>
</html>
