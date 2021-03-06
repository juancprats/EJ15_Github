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
        
           <form action="${ pageContext.request.contextPath}/Tienda/Modificar2" method="post">
        <tr>
       
            <td><input type="text" name="id" value="<%=c.getId()%>"></td>
            <td><input type="text" name="nombre" value="<%=c.getName()%>"></td>
            <td><input type="text" name="apellidos" value="<%=c.getApellido()%>"></td>
            <td><input type="text" name="dni" value="<%=c.getDni()%>"></td>
             <td><input type="submit" name="modificar" value="Modificar"></td>
            
        </tr>
        
     </form>

        <%}%>
        
    </table>
<%@ include file="../Templates/footer.jsp"%>