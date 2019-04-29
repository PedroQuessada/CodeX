package service;

import java.io.Serializable;

import dao.ProdutoDAO;
import model.Produto;

public class ProdutoService implements Serializable{
	
	ProdutoDAO dao;
	
	public ProdutoService() {
		dao = new ProdutoDAO();
	}
	
	public void createEndereco(Produto produto) {
		dao.createProduto(produto);
	}
	
	public void updateProduto(Produto produto) {
		dao.updateProduto(produto);
	}
	
	public void deleteProduto(int id) {
		dao.deleteProduto(id);
	}

	public Produto loadProduto(int id) {
		return dao.loadProduto(id);
	}
	
}
