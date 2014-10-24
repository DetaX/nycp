<%-- 
    Document   : final_discharge
    Created on : Oct 24, 2014, 12:20:57 PM
    Author     : DetaX
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Take final discharge decision</title>
    </head>
    <body>
        <h1>Take final discharge decision</h1>
        <a href="index.html">Home</a>
        <form action="final_discharge/add" method="post">
            Date of decision : <input type="date" name="decisionDate" /><br/>
            Date of final discharge : <input type="date" name="dischargeDate" /><br/>
            Prisoner : <select name="prisoner" >
                            <c:forEach var="prisoner" items="${prisoners}">
                                <option value="${prisoner[2]}">${prisoner[0]} ${prisoner[1]}</option>
                            </c:forEach>
            </select><br/>
            <input type="submit" value="Submit" />
        </form>

    </body>
</html>

