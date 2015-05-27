<%@page import="java.time.LocalDateTime"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../css/estilos.css">
<title>Lista de todo</title>
</head>
<body>
<!-- tabla html dinamicamente -->
<h1><%= request.getAttribute("titulo") %></h1>
<span><%=LocalDateTime.now() %></span><br>
<span>Valor enviado desde el servlet: </span>
<span><%= request.getAttribute("iva") %></span><br>
<table>
    <tr>
        <th>ID</th>
        <th>Nombre</th>
        <th>Apellido</th>
        <th>DNI</th>
    </tr>
    <!-- Las siguientes se cargan dinamicamente -->
</table>
</body>
</html>