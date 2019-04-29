package model;

public class Endereco {

	private int id;
	private String rua;
	private int numero;
	private int cep;
	private String bairro;
	private String estado;
	private String cidade;
	private String pais;
	private int complemento;
	private String observacao;
	
	public Endereco() {
		// TODO Auto-generated constructor stub
	}

	public Endereco(int id, String rua, int numero, int cep, String bairro, String estado, String cidade, String pais,
			int complemento, String observacao) {
		super();
		this.id = id;
		this.rua = rua;
		this.numero = numero;
		this.cep = cep;
		this.bairro = bairro;
		this.estado = estado;
		this.cidade = cidade;
		this.pais = pais;
		this.complemento = complemento;
		this.observacao = observacao;
	}

	public Endereco(int id, String rua, int numero, int cep, String bairro, String estado, String cidade, String pais) {
		super();
		this.id = id;
		this.rua = rua;
		this.numero = numero;
		this.cep = cep;
		this.bairro = bairro;
		this.estado = estado;
		this.cidade = cidade;
		this.pais = pais;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getCep() {
		return cep;
	}

	public void setCep(int cep) {
		this.cep = cep;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public int getComplemento() {
		return complemento;
	}

	public void setComplemento(int complemento) {
		this.complemento = complemento;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
	
	
	
	
	
}
