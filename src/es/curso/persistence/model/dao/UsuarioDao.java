package es.curso.persistence.model.dao;

import es.curso.model.entity.Usuario;

public interface UsuarioDao {
	public Usuario search(String user, String ps);

}
