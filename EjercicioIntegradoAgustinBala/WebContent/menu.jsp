<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="/jruteros/styles/menu.css" />
<title>Insert title here</title>
</head>
<body>
<div class="menu_simple">
<ul>

<%
    if(request.getSession(false) == null || request.getSession().getAttribute("perfil") == null) {
		response.sendRedirect("/jruteros/login.html");	
    } else {
    String perfil = request.getSession().getAttribute("perfil").toString();
    if(perfil.equals("administrador")) { %>
    	 <%="<li><a href='/jruteros/administrarUsuarios.jsp'>Administrar Usuarios</a></li>"+
    	    "<li><a href='/jruteros/administrarActividades.jsp'>Administrar Actividades</a></li>" %>
<%    }
    }%>
<li><a href="/jruteros/rutas.jsp">Rutas</a></li>
<li><a href="/jruteros/misRutas.jsp">Mis Rutas</a></li>
<li><a href="/jruteros/buscarRutas.jsp">Buscar Rutas</a></li>
<li style="float:right"><a class="active" href="/jruteros/logout">Salir</a></li>
</ul>
</div>
<div class="header">
  <img src="/jruteros/images/header.PNG" alt="logo" />
</div>
</body>
</html>