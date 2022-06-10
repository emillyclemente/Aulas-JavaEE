package br.com.senai.emillyclemente.model;

public class Estado {
	
	private String sigla;
	private String nome;

	public Estado() { //Construtor vazio
		
	}
	
	public Estado(String sigla, String nome) { //Construtor com parametros
		super();
		this.sigla = sigla;
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	
	
	
}
	
	