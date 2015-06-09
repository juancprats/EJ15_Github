<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../css/estilos.css">
<title>Insert title here</title>
</head>
<body>
<!--  ${ pageContext.request.contextPath} Nos escribe la ruta absoluta-->
<form action="${ pageContext.request.contextPath}/Tienda/Modificar1" method="post">
<label>Nombre</label>
<input type="text" name="nombre"/>
<input type="submit" name="enviar" value="Enviar"/>
<input type="reset" name="borrar" value="Borrar"/>
</form>
</body>
</html>