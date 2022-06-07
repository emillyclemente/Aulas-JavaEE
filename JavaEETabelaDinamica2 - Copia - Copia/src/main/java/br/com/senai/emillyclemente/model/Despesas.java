package br.com.senai.emillyclemente.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.JoinColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@SuppressWarnings("serial")
@Entity//Entidade
public class Despesas implements Serializable {

	@Id//Gera o ID que vai identificar os atributos cadastrados na tabela
	@GeneratedValue
	
	private Integer id;
	private String data;
	private String descricao;
	private Double valor;
	private boolean edit;
	
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "despesas_produtos",
			joinColumns = @JoinColumn(name = "despesas_id"),
			inverseJoinColumns = @JoinColumn(name = "produtos_idProduto"))
	private List<Produtos> produtos = new ArrayList<Produtos>();
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getData() {
		return data;
	}
	public void setData(String data) {
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
	
	public Despesas(String data, String descricao, Double valor) { //Construtor com parâmetros, que anula o construtor vazio
		super();
		this.data = data;
		this.descricao = descricao;
		this.valor = valor;
	}
	
	public Despesas() { //Construtor vazio
		super();
	}
	
	
}
