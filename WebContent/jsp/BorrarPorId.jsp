<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../Templates/cabecera.jsp"%>
<!--  ${ pageContext.request.contextPath} Nos escribe la ruta absoluta-->
<form action="${ pageContext.request.contextPath}/Tienda/BorrarPorId" method="post">
<label>Nombre</label>
<input type="text" name="id"/>
<input type="submit" name="enviar" value="Borrar registro"/>
<input type="reset" name="borrar" value="Borrar"/>
</form>
<%@ include file="../Templates/footer.jsp"%>