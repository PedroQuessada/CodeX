package model;

import java.sql.Date;

public class Produto {
	
	private int id;
	private int nome;
	private int quantidade;
	private Date dataEntrada;
	private Date dataSaida;
	private double valor;
	private double custo;
	private String descricao;
	private int qtdMinimo;
	private PessoaJuridica pessoaJuridica;
	
	public Produto() {
		// TODO Auto-generated constructor stub
	}

	
	public Produto(int id, int nome, int quantidade, Date dataEntrada, Date dataSaida, double valor, double custo,
			String descricao, int qtdMinimo, PessoaJuridica pessoaJuridica) {
		super();
		this.id = id;
		this.nome = nome;
		this.quantidade = quantidade;
		this.dataEntrada = dataEntrada;
		this.dataSaida = dataSaida;
		this.valor = valor;
		this.custo = custo;
		this.descricao = descricao;
		this.qtdMinimo = qtdMinimo;
		this.pessoaJuridica = pessoaJuridica;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNome() {
		return nome;
	}

	public void setNome(int nome) {
		this.nome = nome;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Date getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(Date dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public Date getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(Date dataSaida) {
		this.dataSaida = dataSaida;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public double getCusto() {
		return custo;
	}

	public void setCusto(double custo) {
		this.custo = custo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getQtdMinimo() {
		return qtdMinimo;
	}

	public void setQtdMinimo(int qtdMinimo) {
		this.qtdMinimo = qtdMinimo;
	}

	public PessoaJuridica getPessoaJuridica() {
		return pessoaJuridica;
	}

	public void setPessoaJuridica(PessoaJuridica pessoaJuridica) {
		this.pessoaJuridica = pessoaJuridica;
	}
	
	

}
