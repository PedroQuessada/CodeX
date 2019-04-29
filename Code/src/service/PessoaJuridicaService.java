package service;

import java.io.Serializable;

import dao.PessoaJuridicaDAO;
import model.PessoaJuridica;

public class PessoaJuridicaService implements Serializable{

	PessoaJuridicaDAO dao;
	
	public PessoaJuridicaService() {
		dao = new PessoaJuridicaDAO();
	}
	
	public void createPessoaJuridica(PessoaJuridica pessoaJuridica) {
		dao.createPessoaJuridica(pessoaJuridica);
	}
	
	public void updatepessoaFisica(PessoaJuridica pessoaJuridica) {
		dao.updatepessoaFisica(pessoaJuridica);
	}
	
	public void deletepessoaJuridica(int id) {
		dao.deletepessoaJuridica(id);
	}
	
	public PessoaJuridica loadPessoaJuridica(int id) {
		return dao.loadPessoaJuridica(id);
	}
	
}
