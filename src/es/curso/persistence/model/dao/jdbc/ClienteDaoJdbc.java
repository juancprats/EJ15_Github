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

		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
			// cx.setAutoCommit(false);
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

}
