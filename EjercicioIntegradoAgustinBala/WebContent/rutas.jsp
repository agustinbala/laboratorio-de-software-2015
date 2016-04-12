<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" type="text/css" href="/jruteros/styles/main.css" />
<title>Rutas</title>
</head>
<body>
<%
    if(request.getSession(false) == null) {
		response.sendRedirect("/jruteros/login.html");	
    } %>
    <%@ include file="menu.jsp" %>
<div id="content-wrapper">
<div id="content">
<h1>Rutas</h1>
</div>
</div>
</body>
</html>