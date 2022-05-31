package br.com.rafaelcosta.application.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Cliente implements Serializable {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(length = 100, nullable = false) //configuração direta  //nullable diz se pode ou não ficar nulo //length é varchar
	private String nome;
	
	@Column(length = 50, nullable = false)
	private String email;

	@OneToMany(mappedBy = "cliente") //um cliente para muitos pedidos  //cliente recebe a pk de pedido
	private List<Pedido> pedidos;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", email=" + email + "]";
	}
}

