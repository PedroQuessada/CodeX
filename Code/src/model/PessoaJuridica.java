package model;

public class PessoaJuridica {
	
	private int id;
	private String nomeFantasia;
	private int cnpj;
	private Cliente cliente;
	private int fornecedor;
	
	public PessoaJuridica() {
		// TODO Auto-generated constructor stub
	}

	public PessoaJuridica(int id, String nomeFantasia, int cnpj, Cliente cliente) {
		super();
		this.id = id;
		this.nomeFantasia = nomeFantasia;
		this.cnpj = cnpj;
		this.cliente = cliente;
	}
	
	public PessoaJuridica(int id, String nomeFantasia, int cnpj, Cliente cliente, int fornecedor) {
		super();
		this.id = id;
		this.nomeFantasia = nomeFantasia;
		this.cnpj = cnpj;
		this.cliente = cliente;
		this.fornecedor = fornecedor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public int getCnpj() {
		return cnpj;
	}

	public void setCnpj(int cnpj) {
		this.cnpj = cnpj;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public int getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(int fornecedor) {
		this.fornecedor = fornecedor;
	}
	
	

}
