package br.com.senai.emillyclemente.application.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import br.com.senai.emillyclemente.jpa.ejbbean.DespesaBean;
import br.com.senai.emillyclemente.jpa.ejbbean.ProdutoBean;
import br.com.senai.emillyclemente.model.Despesas;
import br.com.senai.emillyclemente.model.Produtos;

@SuppressWarnings("serial") //Para tirar o aviso de cuidado do Eclipse
@SessionScoped //Tempo de vida da página, o session mantem os dados enquanto o navegador estiver aberto
@Named("tabela") //Como o bean vai ser chamado

public class TabelaBean implements Serializable{

	@EJB
	private DespesaBean despesabean; //Váriavel que vai fazer a conexão com o EJB
	
	@EJB
	private ProdutoBean produtobean;
	
	private Integer despesaID; //ID das despesas
	
	private List<Despesas> despesas = new ArrayList<>();//recebe a lista chamada 'despesa' e grava na tabela
	
	String data;
	String descricao;
	Double valor;
	Boolean back = false;
	private List<Produtos> produtos;
	private Integer[] selectedProdutosIds;
	

	@PostConstruct
	public void init() {
		produtos = produtobean.listar();
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
	
	public Boolean getBack() {
		return back;
	}
	public void setBack(Boolean back) {
		this.back = back;
	}
	
	//Cria um novo objeto dentro da tabela 
	public String inserir(String data, String descricao, Double valor) {
		Despesas d = new Despesas(data, descricao, valor);//adiciona uma nova despesa na lista guardando na váriavel 
		d.setEdit(true);
		back = true;
		despesabean.inserir(d);
		despesas.add(d);
		data = null;
		descricao = null;
		valor = null;
		return null;
	}
	
	//Remove a despesa cadastrada de dentro da tabela
	public void excluir(Despesas despesa) {
		despesabean.excluir(despesa);
		despesas = null;
	}
	
	//Faz com que seja possivel alterar as informações já inseridas na tabela, editando qualquer um dos campos que já foram inseridos
	public String editar(Despesas despesa) { 
		despesa.setEdit(true);
		return null;
	}
	
	//Muda a forma que manipula a tabela, e salva as informações alteradas
	public String gravar(Despesas despesa) { 
		despesa.setEdit(false);
		return null;
	}
	
	//Mostra todas as depesas da tabela
	public List<Despesas> getDespesas(){
		if(despesas==null) {
			 List<Despesas> despesas = new ArrayList<>();
		}
		return despesas;
	}
	
	
	public List<Produtos> getProdutos() { //Listar todos os produtos
		return produtos;
	}

	public Integer[] getSelectedProdutosIds() {
		return selectedProdutosIds;
	}

	public void setSelectedProdutosIds(Integer[] selectedProdutosIds) {
		this.selectedProdutosIds = selectedProdutosIds;
	}

}
