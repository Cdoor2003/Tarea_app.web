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
    <title>Registro usuario</title>
    <link rel="stylesheet" type="text/css" href="estilos.css">
    <script src="script.js" ></script>
</head>
<body>
<h1 class="encabezado">Registro usuario</h1>
<h2 class="subtitulo">${textoRespuesta}</h2>
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
        <button class="animated-button" type="submit" onclick="animateButton()">Registrar</button>
    </div>
</form>
</body>
</html>
