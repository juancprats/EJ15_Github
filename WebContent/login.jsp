 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ include file="../Templates/cabecera.jsp"%> 
 
   
    <form action="${pageContext.request.contextPath}/Tienda/login" method="post" enctype="text/html" name="form1">
    <fieldset>
     <legend>Login</legend>
    
            <label>Nombre de usuario:</label>
            <input type="text" name="userName" required="required"/>
            <label>Contraseña:</label>
            <input type="password" name="password" required="required"/>
            
            <br>
            <br>
            
            <input type="submit" name="enviar" value="Login"/>
        
    </fieldset>
   </form>
   
 
   <%@ include file="../Templates/footer.jsp"%>