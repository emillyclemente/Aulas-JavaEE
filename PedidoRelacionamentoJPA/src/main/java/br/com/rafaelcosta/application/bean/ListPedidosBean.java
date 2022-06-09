package br.com.rafaelcosta.application.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.rafaelcosta.application.ejb.PedidoBean;
import br.com.rafaelcosta.application.model.Pedido;

//Lista de todos os pedidos

@Named
@RequestScoped //ele é iniciado quando uma requisição é realizada, após a resposta, o tempo de vida do bean acaba
public class ListPedidosBean implements Serializable {

	@EJB //EJB, conexão com o banco de dados
	private PedidoBean pedidoBean; 
	
	private List<Pedido> pedidos; 
	
	@PostConstruct //Carrega o pedido e guarda na lista
	public void init() {
		pedidos = pedidoBean.listar();
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}
	
	public String pagar(Integer pedidoId, String tipo) throws Exception  { //Recebe o pedido, o número do mesmo, e qual vai ser o tipo de pagamento. Ele repassa para o bean do EJB redirecionando
		pedidoBean.pagar(pedidoId, tipo);
		return "pedidos?faces-redirect=true";
	}
	
	public String excluir(Integer pedidoId) { //O redirecionamento com as informações atualizadas
		pedidoBean.excluir(pedidoId);
		return "pedidos?faces-redirect=true";
	}
}
