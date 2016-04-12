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
<TR> <TD ALIGN="right">Nombre: </TD>
<TD><INPUT TYPE="Text" NAME="txtUsuario" ALIGN="LEFT" SIZE="15"></TD>
</TR>
<TR> <TD ALIGN="right">Descripción: </TD>
<TD><textarea name="comment" form="new_route_form"></textarea></TD>
</TR>
<TR> <TD ALIGN="right">Privacidad: </TD>
<TD> <input type="radio" name="privacidad" value="publica">Publica
<input type="radio" name="privacidad" value="privada" >Privada<br></TD>
</TR>
<TR> <TD ALIGN="right">Formato: </TD>
<TD> <input type="radio" name="formato" value="ida">Ida
<input type="radio" name="formato" value="circular" >Circular<br></TD>
</TR>
<TR> <TD ALIGN="right">Recorrido: </TD>
<TD><input type="file" name="img"></TD>
</TR>
<TR> <TD ALIGN="right">Distancia: </TD>
<TD><input type="text" name="distancia"></TD>
</TR>
<TR> <TD ALIGN="right">Dificultad: </TD>
<TD><select name="dificultad">
  <option value="facil">Fácil</option>
  <option value="moderado">Moderado</option>
  <option value="dificil">Dificil</option>
  <option value="muy_dificil">Muy Dificil</option>
  <option value="expertos">Sólo Expertos</option>
</select></TD>
</TR>
<TR> <TD ALIGN="right">Actividad: </TD>
<TD><select name="actividad">
  <option value="Mountain">Mountain bike</option>
  <option value="Ciclismo">Ciclismo</option>
  <option value="Cicloturismo">Cicloturismo</option>
  <option value="Senderismo">Senderismo</option>
  <option value="Montaña">Carrera por montaña</option>
  <option value="Alpinismo">Alpinismo</option>
  <option value="Motociclismo">Motociclismo</option>
  <option value="Cuatriciclo"> Cuatriciclo</option>
  <option value="Esquí">Esquí</option>
  <option value="Kayac">Kayac</option>
  <option value="Vela">Vela</option>
  <option value="caballo">A caballo</option>
</select></TD>
</TR>
<TR> <TD ALIGN="right">Tiempo estimado: </TD>
<TD><input type="text" name="tiempo"></TD>
</TR>
<TR> <TD ALIGN="right">Fecha de realizacion: </TD>
<TD><input type="date" name="fechaDeRealizacion"></TD>
</TR>
<TR> <TD ALIGN="right">Fotos: </TD>
<TD><input type="file" name="img"></TD>
</TR>
<TR><TD ALIGN="right"></TD><TD><INPUT ALIGN="LEFT" TYPE="Submit" NAME="enviar" VALUE="Guardar"></TD>
</TR>
</TABLE>
</FORM>     
</div>
</body>
</html>