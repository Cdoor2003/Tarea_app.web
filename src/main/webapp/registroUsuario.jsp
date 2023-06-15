<%--
  Created by IntelliJ IDEA.
  User: dorde
  Date: 01-06-2023
  Time: 9:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link rel="stylesheet" type="text/css" href="estilos.css">
  <title>Registro usuario</title>
</head>
<body>
<h1 class="encabezado">Registro usuario</h1>
<form action="registroUsuario" method="post">
  <div class="centrado">
    <label>Nombre: </label>
    <input name="nombre" type="text" class="campoTexto">
    <br><br>
    <label>Edad: </label>
    <input name="edad" type="number" class="campoTexto">
    <br><br>
    <label>RUT: </label>
    <input name="rut" type="text" class="campoTexto">
    <br><br>
    <input type="submit" value="enviar" class="boton">
  </div>
</form>
</body>
</html>
