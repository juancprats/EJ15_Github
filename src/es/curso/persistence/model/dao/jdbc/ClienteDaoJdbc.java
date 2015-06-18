package es.curso.persistence.model.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.PreparedStatement;

import es.curso.model.entity.Cliente;
import es.curso.persistence.model.dao.ClienteDao;

public class ClienteDaoJdbc implements ClienteDao {

	private Connection cx;

	public ClienteDaoJdbc() {
		super();

	}

	@Override
	public void create(Cliente cliente) {
		// instrucc de alta en BBDD
		// 1. conectar BBDD
		abrirConexion();
		// 2. preparar las sentencias para añadir
		try {
			PreparedStatement ps = cx
					.prepareStatement("INSERT INTO cliente VALUES(?,?,?,?)");
			// INSERTAR LOS DATOS DEL Cliente en los ?

			ps.setInt(1, 0);
			ps.setString(2, cliente.getName());
			ps.setString(3, cliente.getApellido());
			ps.setString(4, cliente.getDni());
			// 3. ejecutar las sentencias sql
			ps.executeUpdate();// se utiliza para instrucciones como INSERT
								// DELETE UPDATE
								// devuelve el numero de registro de filas
								// afectadas
			// 3.1 hacer commit
			cx.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				cx.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}

		// 4. cerrar conexión

		finally {
			cerrarConexion();
		}
	}

	@Override
	public ArrayList<Cliente> findAll() {
		ArrayList<Cliente> cliente = new ArrayList<Cliente>();
		try {
			abrirConexion();

			PreparedStatement ps = cx.prepareStatement("SELECT * FROM cliente");
			ResultSet consulta = ps.executeQuery();
			while (consulta.next()) {
				Cliente clienteTemporal = new Cliente();
				clienteTemporal.setId(consulta.getInt("idCliente"));
				clienteTemporal.setName(consulta.getString("name"));
				clienteTemporal.setApellido(consulta.getString("apellido"));
				clienteTemporal.setDni(consulta.getString("dni"));

				cliente.add(clienteTemporal);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			cerrarConexion();
		}
		return cliente;
	}

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
	public ArrayList<Cliente> searchByName(String name) {

		ArrayList<Cliente> cliente = new ArrayList<Cliente>();
		abrirConexion();
		try {
			PreparedStatement ps = cx
					.prepareStatement("SELECT * FROM cliente WHERE name LIKE ?");
			ps.setString(1, name + "%");// En el primer interrogante ponemos el
										// parametro name
			ResultSet consulta = ps.executeQuery();
			while (consulta.next()) {
				Cliente clienteTemporal = new Cliente();
				clienteTemporal.setId(consulta.getInt("idCliente"));
				clienteTemporal.setName(consulta.getString("name"));
				clienteTemporal.setApellido(consulta.getString("apellido"));
				clienteTemporal.setDni(consulta.getString("dni"));

				cliente.add(clienteTemporal);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return cliente;
	}

	@Override
	public void update(Cliente cliente) {
		abrirConexion();
		PreparedStatement ps;
		try {
			ps = cx.prepareStatement("UPDATE cliente SET name=?, apellido=?, dni=?  WHERE idCliente = ?");

			ps.setString(1, cliente.getName());
			ps.setString(2, cliente.getApellido());
			ps.setString(3, cliente.getDni());
			ps.setInt(4, cliente.getId());

			ps.executeUpdate();
			cx.commit();

		} catch (SQLException e) {
			try {
				cx.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		finally {
			cerrarConexion();
		}

	}

	public boolean delete(String id) {
		/* ArrayList<Cliente> cliente = new ArrayList<Cliente>(); */
		abrirConexion();
		int filas = 0;
		PreparedStatement ps;

		try {
			ps = cx.prepareStatement("DELETE FROM cliente WHERE name = ?");

			ps.setString(1, id);// En el primer interrogante ponemos el
								// parametro name

			filas = ps.executeUpdate();
			cx.commit();
			;
		} catch (SQLException e) {
			try {
				cx.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (filas > 0)
			return true;
		else
			return false;

	}

}
