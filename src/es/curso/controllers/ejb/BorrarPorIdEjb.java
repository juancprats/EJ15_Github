package es.curso.controllers.ejb;

import es.curso.controllers.BorrarPorId;
import es.curso.persistence.model.dao.jdbc.ClienteDaoJdbc;

public class BorrarPorIdEjb implements BorrarPorId{

		
public boolean borrarPorId(Integer id) {
		
		ClienteDaoJdbc daoCliente = new ClienteDaoJdbc();
		return daoCliente.delete(id);
		
		
		
	}

}
