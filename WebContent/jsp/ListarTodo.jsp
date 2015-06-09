<%@page import="es.curso.model.entity.Cliente"%>
<%@page import="java.util.ArrayList"%>
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
	<h1><%=request.getAttribute("titulo")%></h1>
	<span><%=LocalDateTime.now()%></span>
	<br>

	<br>
	<%ArrayList<Cliente> clientes = (ArrayList<Cliente>) request.getAttribute("clientes");%>
	<table>
		<tr>
			<th>ID</th>
			<th>Nombre</th>
			<th>Apellido</th>
			<th>DNI</th>
			<th></th>
		</tr>
		<!-- Las siguientes se cargan dinamicamente -->
   
		<%for (Cliente c : clientes) {%>
		
			
		<tr>
		 <form action="${ pageContext.request.contextPath}/Tienda/BorrarPorId"  method="post">
			<td><input type="text" name="id" value="<%=c.getId()%>"></td>
			<td><%=c.getName()%></td>
			<td><%=c.getApellido()%></td>
			<td><%=c.getDni()%></td>
			<td><input type="submit" name="<%=c.getId()%>" value="Eliminar" /></td>
        </form>
		</tr>
		
	

		<%}%>
		
	</table>
</body>
</html>