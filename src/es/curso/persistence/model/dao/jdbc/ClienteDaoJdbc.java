package es.curso.persistence.model.dao.jdbc;

import java.util.ArrayList;

import es.curso.model.entity.Cliente;
import es.curso.persistence.model.dao.ClienteDao;

public class ClienteDaoJdbc implements ClienteDao{

	private ArrayList<Cliente> cliente;
	
	
	
	public ClienteDaoJdbc() {
		super();
		cliente = new ArrayList<Cliente>();
	}


	@Override
	public void create(Cliente cliente) {
		// instrucc de alta en BBDD
		// 1. concetar BBDD
		// 2. preparar las sentencias para añadir
		// 3. ejecutar las sentencias sql
		// 4. cerrar conexión		
	}
	

	@Override
	public ArrayList<Cliente> findAll() {
		// TODO Auto-generated method stub
		
		cliente.add(new Cliente(1,"Jose","PErez", "1236"));
		cliente.add(new Cliente(2,"Luis","Lopez", "2589"));
		cliente.add(new Cliente(3,"Manuel","Sanchez", "33369"));
		cliente.add(new Cliente(4,"Alvaro","Saez", "47814"));
		cliente.add(new Cliente(5,"Mariano","Otero", "25841"));
		cliente.add(new Cliente(6,"Raul","PErez", "82255"));
		cliente.add(new Cliente(8,"Raquel","Ortega", "457"));
		cliente.add(new Cliente(9,"Toñi","Casa", "68541"));
		cliente.add(new Cliente(10,"Carmen","Ruiz", "25874"));
		return cliente;
	}

}
