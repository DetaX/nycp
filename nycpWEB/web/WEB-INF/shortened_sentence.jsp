<%-- 
    Document   : shortened_sentence
    Created on : Oct 24, 2014, 12:20:22 PM
    Author     : DetaX
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Take shortened sentence decision</title>
        <link rel="stylesheet" href="pure-min.css">
    </head>
    <body>
        <a href="index.html" class="pure-button">Home</a>
        <form action="shortened_sentence/add" method="post" class="pure-form pure-form-aligned">
            <fieldset>
                <legend>Take shortened sentence decision</legend>
                <div class="pure-control-group">
                
                    <label for="date">Date of decision</label><input type="date" name="date" id="date"/><br/>
            <label for="duration">Duration</label><input type="number" name="duration" min="0" id="duration" /><br/>
            <label for="prisoner">Prisoner</label><select name="prisoner" id="prisoner">
                            <c:forEach var="prisoner" items="${prisoners}">
                                <option value="${prisoner[2]}">${prisoner[0]} ${prisoner[1]}</option>
                            </c:forEach>
            </select><br/>
            <input type="submit" value="Submit" class="pure-button pure-button-primary" />
            </fieldset>
        </form>

    </body>
</html>
