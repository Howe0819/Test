<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<jsp:useBean id="invalidLogin" class="String" scope="request"/>
<!DOCTYPE html>
<html>
    <head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Event Booking System - Login</title>
    </head>
    <body>
    <h1>Event Booking System - Login</h1>
    <c:url var="formAction" value="/Controller?action=doLogin" />
    <c:if test="${invalidLogin == 'true'}">
        <font color="red">Invalid Login</font><br/>
    </c:if>
    <form id="loginForm" name="loginForm" action="${formAction}"
method="post">
        Username: <input id="userName" name="userName" type="text"/><br/>
        Password: <input id="password" name="password" type="password"/><br/>
        <c:url var="formAction" value="/Controller" />
        <input type="submit" value="Login" /> <input type="button"
value="Cancel" onclick="document.getElementById('loginForm').action='${formAction}';document .getElementById('loginForm').submit();" />
</form>
    </body>
</html>