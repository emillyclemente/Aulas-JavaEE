package br.com.rafaelcosta.application.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.rafaelcosta.application.ejb.ClienteBean;
import br.com.rafaelcosta.application.ejb.PedidoBean;
import br.com.rafaelcosta.application.ejb.ProdutoBean;
import br.com.rafaelcosta.application.model.Cliente;
import br.com.rafaelcosta.application.model.Produto;

//tela para edição de pedido

@Named
@RequestScoped
public class EditPedidoBean implements Serializable {
	
	@EJB //ligação com o banco de dados //crud
	private PedidoBean pedidoBean;
	
	@EJB
	private ProdutoBean produtoBean;
	
	@EJB
	private ClienteBean clienteBean;
	
	private List<Cliente> clientes; //listagem de todos os clientes e produtos
	private List<Produto> produtos;
	
	private Integer selectedClienteId; //descrição do id do cliente, inserido no dropdown
	private Integer[] selectedProdutosIds; //list que carrega os produtos do checkbox na tela
	
	@PostConstruct  //assim que carregou a página, é listado //inicialização de objetos que estão guardados no banco de dados
	public void init() {
		clientes = clienteBean.listar();
		produtos = produtoBean.listar();
	}
	
	public String cadastrarPedido() throws Exception {  //pedidoBean e lançar cadastrar > idcliente + idproduto
		pedidoBean.cadastrar(selectedClienteId, selectedProdutosIds);	
		return "pedidos?faces-redirect=true"; //depois de cadastrar, apaga o que esta na tela
	}
	
	public List<Cliente> getClientes() { //listar todos os clientes
		return clientes;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public Integer getSelectedClienteId() {
		return selectedClienteId;
	}

	public void setSelectedClienteId(Integer selectedClienteId) { //preenchimento cliente
		this.selectedClienteId = selectedClienteId;
	}

	public Integer[] getSelectedProdutosIds() {
		return selectedProdutosIds;
	}

	public void setSelectedProdutosIds(Integer[] selectedProdutosIds) {
		this.selectedProdutosIds = selectedProdutosIds;
	}
}