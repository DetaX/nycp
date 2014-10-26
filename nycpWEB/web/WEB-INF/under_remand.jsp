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
        <link rel="stylesheet" href="pure-min.css">
    </head>
    <body>
        <a href="index.html" class="pure-button">Home</a>
        <div style>
        <fieldset>
        <legend>Prisoners under remand</legend>
        <table class="pure-table">
            <thead>
                <tr>
                <th>prison file number</th>
                <th>given name</th>
                <th>surname</th>
                <th>date of birth</th>
                <th>place of birth</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="prisoner" items="${prisoners}" varStatus="loop">
                    <tr <c:if test="${loop.count % 2 == 0}">class="pure-table-odd"</c:if>>
                        <td>${prisoner[3]}</td>
                        <td>${prisoner[1]}</td>
                        <td>${prisoner[1]}</td>
                        <td>${prisoner[4]}</td>
                        <td>${prisoner[2]}</td>
                    </tr>
                 </c:forEach>
            </tbody>
        </table>
        </fieldset>
        </div>
    </body>
</html>
