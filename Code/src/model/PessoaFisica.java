package model;

public class PessoaFisica {
	
	private int id;
	private int cpf;
	private Cliente cliente;
	
	public PessoaFisica() {
		// TODO Auto-generated constructor stub
	}

	public PessoaFisica(int id, int cpf, Cliente cliente) {
		super();
		this.id = id;
		this.cpf = cpf;
		this.cliente = cliente;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	

}
