<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 <%@ include file="../Templates/cabecera.jsp"%> 
 
   
    <form action="../Tienda/altaCliente" method="post" enctype="text/html" name="form1">
    <fieldset>
     <legend>Alta de Cliente</legend>
    
            <label>Nombre del cliente:</label>
            <input type="text" name="nombre" required="required"/>
            <label>Apellido:</label>
            <input type="text" name="apellido" required="required"/>
            <label>DNI:</label>
            <input type="text" name="dni" required="required"/>
            <input type="hidden" name="id" id="id" />
            <br>
            <br>
            <input type="reset" name="borrar" value="BORRAR"/>
            <input type="submit" name="enviar" value="ENVIAR"/>
        
    </fieldset>
   </form>
   
 
   <%@ include file="../Templates/footer.jsp"%>