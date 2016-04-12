<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" type="text/css" href="menu.css">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Socialización de rutas</title>
</head>
<body>
    <%@ include file="userMenu.html" %>
    
 <div style="padding:20px;margin-top:30px;height:1500px;">    
 
 <details>
  <summary>Ruta 1</summary>
  <p>Detalle de la ruta</p>
  <p><input type="checkbox" name="vehicle" value="Bike">Yo Hice esta ruta</p>
  <div class="stars">

  <form action="">

    <input class="star star-5" id="star-5" type="radio" name="star"/>

    <label class="star star-5" for="star-5"></label>

    <input class="star star-4" id="star-4" type="radio" name="star"/>

    <label class="star star-4" for="star-4"></label>

    <input class="star star-3" id="star-3" type="radio" name="star"/>

    <label class="star star-3" for="star-3"></label>

    <input class="star star-2" id="star-2" type="radio" name="star"/>

    <label class="star star-2" for="star-2"></label>

    <input class="star star-1" id="star-1" type="radio" name="star"/>

    <label class="star star-1" for="star-1"></label>

  </form>
 
</details>
</div>
</body>
</html>