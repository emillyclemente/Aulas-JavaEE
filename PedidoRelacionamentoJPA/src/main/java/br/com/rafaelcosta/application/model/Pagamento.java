package br.com.rafaelcosta.application.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity//Entidade
public class Pagamento implements Serializable {
	public enum TipoPagamento { //Enum para deixar padronizado
		CARTAO_CREDITO,
		BOLETO
	}

	@Id
	@GeneratedValue //Gera o ID que vai identificar os atributos cadastrados na tabela
	private Integer id;
	
	@Enumerated(EnumType.STRING) //
	@Column(name = "tipo_pagto", length = 20, nullable = false) //Indicando o nome da coluna do banco, quantidade de letras e que n pode ficar nulo
	private TipoPagamento tipoPagto;
	
	@OneToOne(mappedBy = "pagamento") //Um para um, um pedido para um pagamento. A tabela pagamento recebe a pk
	private Pedido pedido;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TipoPagamento getTipoPagto() {
		return tipoPagto;
	}

	public void setTipoPagto(TipoPagamento tipoPagto) {
		this.tipoPagto = tipoPagto;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	@Override
	public String toString() {
		return "Pagamento [id=" + id + ", tipoPagto=" + tipoPagto + "]";
	}
}
