<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" type="text/css"
	href="/EJ15_Github/css/estilos.css">
<title>Tienda</title>
</head>
<body>
	<%
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Cache-Control", "no-store");
		response.setDateHeader("Expires", 0);
		response.setHeader("Pragma", "no-cache");
	%>
	<table>
		<tr>
			<%HttpSession miSession = request.getSession();%>
			<% if (miSession.getAttribute("username") == null) {%>

			<th><a href="${pageContext.request.contextPath}/Tienda/log">Login</a></th>
			<%	} else { %>
			<p>
				Usuario:
				<%=miSession.getAttribute("username")%></p>
			<p>
				Bienvenido:
				<%=miSession.getAttribute("nombreCompleto")%></p>
			<th><a
				href="${pageContext.request.contextPath}/Tienda/altaCliente">Alta
					cliente </a></th>
			<th><a
				href="${pageContext.request.contextPath}/Tienda/ListaTodo">Listado
					Clientes</a></th>
			<th><a
				href="${pageContext.request.contextPath}/Tienda/BuscarPorNombre">Consultar
					nombre</a></th>
			<th><a
				href="${pageContext.request.contextPath}/Tienda/BorrarPorId">Borrar
					registro</a></th>
			<th><a
				href="${pageContext.request.contextPath}/Tienda/Modificar">Modificar
					registro</a></th>
			<th><a href="${pageContext.request.contextPath}/Tienda/logOut">Salir</a></th>

			<% } %>

		</tr>
	</table>