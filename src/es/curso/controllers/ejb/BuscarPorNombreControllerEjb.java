package es.curso.controllers.ejb;

import java.util.ArrayList;

import es.curso.controllers.BuscarPorNombreController;
import es.curso.model.entity.Cliente;
import es.curso.persistence.model.dao.jdbc.ClienteDaoJdbc;

public class BuscarPorNombreControllerEjb implements BuscarPorNombreController{

	public ArrayList<Cliente> buscarPorNombre(String cadenaNombre) {
		
		ClienteDaoJdbc daoCliente = new ClienteDaoJdbc();
		ArrayList<Cliente> clientes = daoCliente.searchByName(cadenaNombre);
		return clientes;
		
	}

}
