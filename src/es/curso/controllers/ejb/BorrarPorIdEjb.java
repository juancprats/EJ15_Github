package es.curso.controllers.ejb;

import es.curso.controllers.BorrarPorId;
import es.curso.persistence.model.dao.jdbc.ClienteDaoJdbc;

public class BorrarPorIdEjb implements BorrarPorId{

		
public boolean borrarPorId(String borrar) {
		
		ClienteDaoJdbc daoCliente = new ClienteDaoJdbc();
		return daoCliente.delete(borrar);
		
		
		
	}

}
