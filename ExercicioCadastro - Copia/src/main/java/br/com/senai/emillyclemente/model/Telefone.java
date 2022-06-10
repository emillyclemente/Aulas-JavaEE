package br.com.senai.emillyclemente.model;

public class Telefone {

	private String ddd;
	private String numero;
	private Tipo tipo;
	
	public enum Tipo { //Enum, para enumerar os telefones
		FIXO, CELULAR
	}
	
	public String getDdd() {
		return ddd;
	}
	public void setDdd(String ddd) {
		this.ddd = ddd;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public Tipo getTipo() {
		return tipo;
	}
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	
	

}
