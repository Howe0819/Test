<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
    <head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Event Booking System</title>
    </head>
    <body>
    <h1>Event Booking System - Main Menu</h1>
    <%
    if(request.getSession().getAttribute("systemUserId") == null)
        {
    %>
    <b>You have not login.</b>
    <%
    } else {
    %>
    <c:url var="linkHref" value="/Controller?action=doLogout" />
    You have login with System User Id:
<%=request.getSession().getAttribute("systemUserId").toString()%>. <a
href="${linkHref}">Logout</a>
<% }%>
    <ul><c:url var="linkHref" value="/Controller?action=viewMyEvents" />
        <li><a href="${linkHref}">View My Events</a></li>
        <c:url var="linkHref" value="/Controller?action=viewAllEvents" />
        <li><a href="${linkHref}">View All Events</a></li>
        <c:url var="linkHref" value="/Controller?action=addNewEvent" />
        <li><a href="${linkHref}">Add New Event</a></li>
    </ul>
    </body>
</html>