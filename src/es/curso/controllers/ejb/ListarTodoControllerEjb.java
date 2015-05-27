package es.curso.controllers.ejb;

import java.util.ArrayList;

import es.curso.controllers.ListarTodoController;
import es.curso.model.entity.Cliente;
import es.curso.persistence.model.dao.jdbc.ClienteDaoJdbc;

public class ListarTodoControllerEjb implements ListarTodoController{

	@Override
	public ArrayList<Cliente> listarTodos() {
		// TODO Auto-generated method stub
		ClienteDaoJdbc daoCliente = new ClienteDaoJdbc();
		ArrayList<Cliente> clientes = daoCliente.findAll();
		return clientes;
	}

}
