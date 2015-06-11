<%@page import="es.curso.model.entity.Cliente"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.time.LocalDateTime"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../Templates/cabecera.jsp"%>
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
		 <form action=""  method="post">
			<td><input type="text" name="id" value="<%=c.getId()%>" size=5></td>
			<td><%=c.getName()%></td>
			<td><%=c.getApellido()%></td>
			<td><%=c.getDni()%></td>
			<td><input type="button" name="<%=c.getId()%>" value="Eliminar"  onclick="enviar(this)"/></td>
			<td><input type="button" name="<%=c.getId()%>" value="Modificar" onclick="enviar(this)" /></td>
        </form>
		</tr>
		
	

		<%}%>
		
	</table>
	<!--  "${ pageContext.request.contextPath}/Tienda/Modificar1"-->
<%@ include file="../Templates/footer.jsp"%>