package br.com.rafaelcosta.application.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.rafaelcosta.application.ejb.PedidoBean;
import br.com.rafaelcosta.application.model.Pedido;

//lista todos os pedidos

@Named
@RequestScoped
public class ListPedidosBean implements Serializable {

	@EJB //linkagem com o bd
	private PedidoBean pedidoBean; 
	
	private List<Pedido> pedidos; 
	
	@PostConstruct //carrega o pedido e guarda na list
	public void init() {
		pedidos = pedidoBean.listar();
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}
	
	public String pagar(Integer pedidoId, String tipo) throws Exception  { //recebe o pedido, numero do pedido e tipo de pagamento e repassa para o bean do ejb, fazendo um redirect
		pedidoBean.pagar(pedidoId, tipo);
		return "pedidos?faces-redirect=true";
	}
	
	public String excluir(Integer pedidoId) { //redirect das informações atualizadas
		pedidoBean.excluir(pedidoId);
		return "pedidos?faces-redirect=true";
	}
}
