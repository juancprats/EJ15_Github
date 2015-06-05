package es.curso.controllers.ejb;

import java.util.ArrayList;

import es.curso.controllers.BorrarPorId;
import es.curso.model.entity.Cliente;
import es.curso.persistence.model.dao.jdbc.ClienteDaoJdbc;

public class BorrarPorIdEjb implements BorrarPorId{

		
public ArrayList<Cliente> borrarPorId(String cadenaNombre) {
		
		ClienteDaoJdbc daoCliente = new ClienteDaoJdbc();
		ArrayList<Cliente> clientes = daoCliente.searchByName(cadenaNombre);
		return clientes;
		
	}

}
