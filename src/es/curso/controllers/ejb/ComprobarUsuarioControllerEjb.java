package es.curso.controllers.ejb;

import es.curso.controllers.ComprobarUsuarioController;
import es.curso.model.entity.Usuario;
import es.curso.persistence.model.dao.jdbc.UsuarioDaoJdbc;

public class ComprobarUsuarioControllerEjb implements ComprobarUsuarioController{

	public Usuario comprobar(String usuario, String contras) {
		UsuarioDaoJdbc doaUsuario = new UsuarioDaoJdbc();
		Usuario u = doaUsuario.search(usuario,contras);
		
		
		
		return u;
		// TODO Auto-generated method stub
		
	}

}
