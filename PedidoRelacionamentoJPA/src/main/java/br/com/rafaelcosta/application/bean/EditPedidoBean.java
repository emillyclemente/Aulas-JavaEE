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

//Edição do pedido

@Named
@RequestScoped //É iniciado quando uma requisição é realizada, após a resposta, o tempo de vida do bean acaba
public class EditPedidoBean implements Serializable {
	
	@EJB //Ligação com o banco de dados
	private PedidoBean pedidoBean;
	
	@EJB
	private ProdutoBean produtoBean;
	
	@EJB
	private ClienteBean clienteBean;
	
	private List<Cliente> clientes; //Listagem de todos os clientes e produtos cadastrados
	private List<Produto> produtos;
	
	private Integer selectedClienteId; //Pega o id do cliente, insere no dropdown
	private Integer[] selectedProdutosIds; //Lista que carrega os produtos do checkbox na tela
	
	@PostConstruct  //Assim que carrega a página, é listado //Inicialização dos objetos que estão no banco de dados
	public void init() {
		clientes = clienteBean.listar();
		produtos = produtoBean.listar();
	}
	
	public String cadastrarPedido() throws Exception {  //pedidoBean junta e cadastra o idcliente + idproduto
		pedidoBean.cadastrar(selectedClienteId, selectedProdutosIds);	
		return "pedidos?faces-redirect=true"; //Depois de cadastrar, ele apaga o que esta na tela
	}
	
	public List<Cliente> getClientes() { //Lista todos os clientes
		return clientes;
	}

	public List<Produto> getProdutos() { //Listar todos os produtos
		return produtos;
	}

	public Integer getSelectedClienteId() {
		return selectedClienteId;
	}

	public void setSelectedClienteId(Integer selectedClienteId) { //Preenchimento de cliente
		this.selectedClienteId = selectedClienteId;
	}

	public Integer[] getSelectedProdutosIds() {
		return selectedProdutosIds;
	}

	public void setSelectedProdutosIds(Integer[] selectedProdutosIds) {
		this.selectedProdutosIds = selectedProdutosIds;
	}
}