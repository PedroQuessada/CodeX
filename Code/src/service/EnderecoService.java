package service;

import java.io.Serializable;

import dao.EnderecoDAO;
import model.Endereco;

public class EnderecoService implements Serializable{

	EnderecoDAO dao;
	
	public EnderecoService() {
		dao = new EnderecoDAO();
	}
	
	public void createEndereco(Endereco endereco) {
		dao.createEndereco(endereco);
	}
	
	public void updateEndereco(Endereco endereco) {
		dao.updateEndereco(endereco);
	}
	
	public void deleteEndereco(int id) {
		dao.deleteEndereco(id);
	}
	
	public Endereco loadEndereco(int id) {
		return dao.loadEndereco(id);
	}
	
}
