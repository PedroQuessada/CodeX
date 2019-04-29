package service;

import java.io.Serializable;

import dao.PessoaFisicaDAO;
import model.PessoaFisica;

public class PessoaFisicaService implements Serializable{
	
	PessoaFisicaDAO dao;
	
	public PessoaFisicaService() {
		dao = new PessoaFisicaDAO();
	}
	
	public void createPessoaFisica(PessoaFisica pessoaFisica) {
		dao.createPessoaFisica(pessoaFisica);
	}
	
	public void updatePessoaFisica(PessoaFisica pessoaFisica) {
		dao.updatePessoaFisica(pessoaFisica);
	}
	
	public void deletePessoaFisica(int id) {
		dao.deletePessoaFisica(id);
	}
	
	public PessoaFisica loadPessoaFisica(int id) {
		return dao.loadPessoaFisica(id);
	}

}
