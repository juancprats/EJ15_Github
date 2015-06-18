package es.curso.persistence.model.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.PreparedStatement;

import es.curso.model.entity.Usuario;
import es.curso.persistence.model.dao.UsuarioDao;

public class UsuarioDaoJdbc implements UsuarioDao {

	private Connection cx;

	private void abrirConexion() {
		// determinar y validar si tengo el driver o conector
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// establecer la conexion..
			cx = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/tienda", "roottienda",
					"roottienda");
			// iniciar autocomit en false
			cx.setAutoCommit(false);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void cerrarConexion() {
		try {
			if (cx != null)
				cx.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public Usuario search(String user, String psw) {

		Usuario usuario = null;
		// Preparamos la sentencia
		PreparedStatement ps;
		try {
			abrirConexion();
			ps = cx.prepareStatement("SELECT * FROM usuario WHERE username=? AND password=?");

			ps.setString(1, user);
			ps.setString(2, psw);
			ResultSet consulta = ps.executeQuery();
			if (consulta.next()) {
				usuario = new Usuario();
				usuario.setId(consulta.getInt("id"));
				usuario.setNombre(consulta.getString("nombre"));
				usuario.setApellido(consulta.getString("apellido"));
				usuario.setUsername(consulta.getString("username"));
				usuario.setPassword(consulta.getString("password"));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			cerrarConexion();
		}
		return usuario;
	}

}
