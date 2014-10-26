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
        <link rel="stylesheet" href="pure-min.css">
    </head>
    <body>
        <a href="index.html" class="pure-button">Home</a>
        <form action="final_discharge/add" method="post" class="pure-form pure-form-aligned">
            <fieldset>
                <legend>Take final discharge decision</legend>
                <div class="pure-control-group">
                    <label for="decisionDate">Date of decision</label><input type="date" name="decisionDate" id="decisionDate"/>
                </div>
                <div class="pure-control-group">
            <label for="dischargeDate">Date of final discharge</label><input type="date" name="dischargeDate" id="dischargeDate" />
            </div>
                <div class="pure-control-group">
                    <label for="prisoner">Prisoner</label><select name="prisoner" id="prisoner" >
                            <c:forEach var="prisoner" items="${prisoners}">
                                <option value="${prisoner[2]}">${prisoner[0]} ${prisoner[1]}</option>
                            </c:forEach>
            </select>
            </div>
            <input type="submit" value="Submit" class="pure-button pure-button-primary" />
            </fieldset>
        </form>

    </body>
</html>

