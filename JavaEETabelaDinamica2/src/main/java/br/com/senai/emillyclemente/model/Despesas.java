package br.com.senai.emillyclemente.model;

import java.util.Date;

public class Despesas {

	private Date data;
	private String descricao;
	private Double valor;
	private boolean edit;
	
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public boolean getEdit() {
		return edit;
	}
	public void setEdit(boolean edit) {
		this.edit = edit;
	}
	
	public Despesas(Date data, String descricao, Double valor) {
		super();
		this.data = data;
		this.descricao = descricao;
		this.valor = valor;
	}
	
	
}
