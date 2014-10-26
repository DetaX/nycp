<%-- 
    Document   : incarcerate
    Created on : Oct 20, 2014, 5:58:38 PM
    Author     : zex
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Incarcerate</title>
    </head>
    <body>
        <h1>Incarcerate</h1>
        <a href="index.html">Home</a>
        <form action="incarcerate/new" method="post">
            Name : <input type="text" name="name"/><br/>
            Surname : <input type="text" name="surname"/><br/>
            Date of birth : <input type="date" name="birthDate" /><br/>
            Place of birth : <input type="text" name="birthPlace" /><br/>
            Jurisdiction : <select name="jurisdiction">
                <c:forEach var="jurisdiction" items="${jurisdiction}">
                    <option value="${jurisdiction}">${jurisdiction}</option>
                </c:forEach>
                    <option value="new">New...</option>
            </select><br/>
            Date of incarceration : <input type="date" name="incarcerationDate" /><br/>
            Date of criminal case : <input type="date" name="date" /><br/>
            Motive : <select name="motive" >
                            <c:forEach var="motive" items="${motive}">
                                <option value="${motive[0]}">${motive[1]}</option>
                            </c:forEach>
                                <option value="new">New...</option>
            </select><br/>
            <input type="submit" value="Submit" />
        </form>

    </body>
</html>