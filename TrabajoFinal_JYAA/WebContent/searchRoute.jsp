<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" type="text/css" href="menu.css">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Socialización de rutas</title>
</head>
<body>
    <%@ include file="userMenu.html" %>
     <div style="padding:20px;margin-top:30px;height:1500px;">
     <FORM id="new_route_form" ACTION="http://localhost:8080/jruteros/register" METHOD="POST">
<TABLE ALIGN="center" WIDTH="100%" CELLSPACING="2" CELLPADDING="2">
<TR> <TD ALIGN="right">Filtrar: </TD>
<TD><select name="filtrar">
  <option value="Actividad">Actividad</option>
  <option value="Formato">Formato</option>
  <option value="Distancia">Distancia</option>
  <option value="Difcultad">Difcultad</option>  
</select></TD>
</TR>
<TR> <TD ALIGN="right">Ordenacion: </TD>
<TD><select name="ordenacion">
  <option value="Distancia">Distancia</option>
  <option value="Dificultad">Dificultad</option>
  <option value="Puntuacion">Puntuacion</option>
  <option value="Personas">Cantidad de Personas</option> 
</select></TD>
</TR>
<TR><TD ALIGN="right"></TD><TD><INPUT ALIGN="LEFT" TYPE="Submit" NAME="enviar" VALUE="Buscar"></TD>
</TR>
</TABLE>
</FORM>     
</div>
</body>
</html>