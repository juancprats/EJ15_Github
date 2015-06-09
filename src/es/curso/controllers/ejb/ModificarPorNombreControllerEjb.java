package es.curso.controllers.ejb;

import java.util.ArrayList;

import es.curso.controllers.ModificarPorNombreController;
import es.curso.model.entity.Cliente;
import es.curso.persistence.model.dao.ClienteDao;
import es.curso.persistence.model.dao.jdbc.ClienteDaoJdbc;

public class ModificarPorNombreControllerEjb implements ModificarPorNombreController{
public ArrayList<Cliente> buscarPorNombre(String cadenaNombre) {
		
		ClienteDaoJdbc daoCliente = new ClienteDaoJdbc();
		ArrayList<Cliente> clientes = daoCliente.searchByName(cadenaNombre);
		return clientes;
		
	}

@Override
public void actualizar(Cliente cliente) {
	ClienteDao clienteDao = new ClienteDaoJdbc();
	clienteDao.update(cliente);
	
}

}
