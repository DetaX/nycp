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
        <link rel="stylesheet" href="pure-min.css">
        <script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
        <script type="text/javascript" src="js/script.js"></script>
    </head>
    <body>
        
        <a href="index.html" class="pure-button">Home</a>
        <form action="incarcerate/new" method="post" class="pure-form pure-form-aligned">
            <fieldset>
                <legend>Incarcerate</legend>
                <div class="pure-control-group">
                <label for="name">Name</label><input type="text" name="name" id="name"/>
                </div>
                <div class="pure-control-group">
            <label for="surname">Surname</label><input type="text" name="surname" id="surname"/>
            </div>
            <div class="pure-control-group">
            <label for="birthDate">Date of birth</label><input type="date" name="birthDate" id="birthDate" />
            </div>
            <div class="pure-control-group">
            <label for="birthPlace">Place of birth</label><input type="text" name="birthPlace" id="birthPlace" />
            </div>
            <div class="pure-control-group">
            <label for="jurisdiction">Jurisdiction</label><select name="jurisdiction" id="jurisdiction">
                <c:forEach var="jurisdiction" items="${jurisdiction}">
                    <option value="${jurisdiction}">${jurisdiction}</option>
                </c:forEach>
                    <option value="new">New...</option>
            </select><input type="text" id="newJurisdiction" style="display:none" name="newJurisdiction"/>
            </div>
            <div class="pure-control-group">
            <label for="date">Date of criminal case</label><input type="date" name="date" id="date" />
            </div>
            <div class="pure-control-group">
            <label for="motive">Motive</label><select name="motive" id="motive">
                            <c:forEach var="motive" items="${motive}">
                                <option value="${motive[0]}">${motive[1]}</option>
                            </c:forEach>
                                <option value="new">New...</option>
            </select><input type="text" id="newMotive" style="display:none" name="newMotive"/>
            </div>
            <div class="pure-control-group">
            <label for="incarcerationDate">Date of incarceration</label><input type="date" name="incarcerationDate" id="incarcerationDate" />
            </div>
            
            <input type="submit" value="Submit" class="pure-button pure-button-primary" />
            
            </fieldset>
        </form>

    </body>
</html>