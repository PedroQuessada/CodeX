package model;

public class PessoaFisica {
	
	private int cpf;
	private Cliente cliente;
	
	public PessoaFisica() {
		// TODO Auto-generated constructor stub
	}

	public PessoaFisica(int cpf, Cliente cliente) {
		super();
		this.cpf = cpf;
		this.cliente = cliente;
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
