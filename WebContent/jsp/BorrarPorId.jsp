<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../css/estilos.css">
<title>Insert title here</title>
</head>
<body>
<!--  ${ pageContext.request.contextPath} Nos escribe la ruta absoluta-->
<form action="${ pageContext.request.contextPath}/Tienda/BorrarPorId" method="post">
<label>Nombre</label>
<input type="text" name="nombre"/>
<input type="submit" name="enviar" value="Borrar registro"/>
<input type="reset" name="borrar" value="Borrar"/>
</form>
</body>
</html>