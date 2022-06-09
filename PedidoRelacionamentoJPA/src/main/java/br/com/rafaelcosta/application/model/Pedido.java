package br.com.rafaelcosta.application.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity //Entidade
public class Pedido implements Serializable {

	@Id //Gera o ID que vai identificar os atributos cadastrados na tabela
	@GeneratedValue
	private Integer id;
	
	@Column(name = "valor_total") //Nome da coluna
	private Double valorTotal;
	
	@Temporal(TemporalType.DATE) //Sinaliza ao banco que o valor é do tipo date
	@Column(nullable = false)
	private Date data;

	@OneToOne //Um pra Um
	@JoinColumn(name = "pagamento_id")
	private Pagamento pagamento;
	
	@ManyToOne//Muitos para um
	@JoinColumn(name = "cliente_id") //Campo que será a chave estrangeira, que vai fazer a ligação
	private Cliente cliente;
	
	@ManyToMany(fetch = FetchType.EAGER) //ManyToMany cria uma terceira tabela com a junção das outras duas
	@JoinTable(name = "pedido_produto", 
		joinColumns = @JoinColumn(name = "pedido_id"), //joincolumns junta as tabelas
		inverseJoinColumns = @JoinColumn(name = "produto_id"))	
	private List<Produto> produtos = new ArrayList<Produto>();

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", valorTotal=" + valorTotal + ", data="
				+ data + "]";
	}
}
