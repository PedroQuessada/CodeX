package service;

import java.io.Serializable;

import dao.ClienteDAO;
import model.Cliente;

public class ClienteService implements Serializable{

	ClienteDAO dao;
	
	public ClienteService() {
		dao = new ClienteDAO();
	}
	
	public void createCliente(Cliente cliente) {
		dao.createCliente(cliente);
	}
	
	public void updateCliente(Cliente cliente) {
		dao.updateCliente(cliente);
	}
	
	public void deleteCliente(int id) {
		dao.deleteCliente(id);
	}
	
	public Cliente loadCliente(int id) {
		return dao.loadCliente(id);
	}
}
