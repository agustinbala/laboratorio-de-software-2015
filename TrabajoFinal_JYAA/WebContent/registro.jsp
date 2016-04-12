<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Socialización de rutas</title>
</head>
<body>
<FORM ACTION="http://localhost:8080/jruteros/register" METHOD="POST">
<H1>Registrarse</H1>
<TABLE ALIGN="center" WIDTH="100%" CELLSPACING="2" CELLPADDING="2">
<TR> <TD ALIGN="right">Nombre de usuario: </TD>
<TD><INPUT TYPE="Text" NAME="txtUsuario" ALIGN="LEFT" SIZE="15"></TD>
</TR>
<TR> <TD ALIGN="right">DNI: </TD>
<TD><INPUT TYPE="Text" NAME="dni" ALIGN="LEFT" SIZE="15"></TD>
</TR>
<TR> <TD ALIGN="right">Apellido y nombre: </TD>
<TD><INPUT TYPE="Text" NAME="txtLastNameAndName" ALIGN="LEFT" SIZE="15"></TD>
</TR>
<TR> <TD ALIGN="right">Domicilio: </TD>
<TD><INPUT TYPE="Text" NAME="txtDomicilio" ALIGN="LEFT" SIZE="15"></TD>
</TR>
<TR> <TD ALIGN="right">Sexo: </TD>
<TD> <input type="radio" name="sexo" value="femenino">Femenino
<input type="radio" name="sexo" value="masculino" >Masculino<br></TD>
</TR>
<TR> <TD ALIGN="right">Fecha de nacimiento: </TD>
<TD><input type="date" name="fechaDeNacimiento"></TD>
</TR>
<TR> <TD ALIGN="right">Email: </TD>
<TD><INPUT TYPE="email" NAME="txtEmail" ALIGN="LEFT" SIZE="15"></TD>
</TR>
<TR><TD ALIGN="right"></TD><TD><INPUT ALIGN="LEFT" TYPE="Submit" NAME="enviar" VALUE="Registrar"></TD>
</TR>
</TABLE>
</FORM>
</body>
</html>