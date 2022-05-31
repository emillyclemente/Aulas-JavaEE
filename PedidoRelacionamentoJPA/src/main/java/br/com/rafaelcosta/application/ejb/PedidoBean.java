package br.com.rafaelcosta.application.ejb;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.rafaelcosta.application.model.Cliente;
import br.com.rafaelcosta.application.model.Pagamento;
import br.com.rafaelcosta.application.model.Pagamento.TipoPagamento;
import br.com.rafaelcosta.application.model.Pedido;
import br.com.rafaelcosta.application.model.Produto;


@Stateless
public class PedidoBean {

	@PersistenceContext
	private EntityManager em;
	
	public List<Pedido> listar() { //carrega todos os pedidos, listagem
		return em.createQuery("SELECT p FROM Pedido p", Pedido.class).getResultList();
	}
	
	public void pagar(Integer pedidoId, String tipo) { //recebe o id e o tipo de pagamneto
		TipoPagamento tipoPagamento = TipoPagamento.valueOf(tipo);
		Pedido pedido = em.find(Pedido.class, pedidoId); //crianção de pesquisa, pesquisado atraves do id
		
		Pagamento pagamento = new Pagamento();
		pagamento.setTipoPagto(tipoPagamento); //set do pagamento dentro do pedido
		em.persist(pagamento);
		
		pedido.setPagamento(pagamento); // set do pedido e atualização no banco de dados
	}
	
	public void excluir(Integer pedidoId) {
		Pedido pedido = em.find(Pedido.class, pedidoId); //procura e depois remove
		em.remove(pedido);
	}
	
	public void cadastrar(Integer clienteId, Integer[] produtosIds) throws Exception { 
		Cliente cliente = em.find(Cliente.class, clienteId); //procura o id do cliente para linkar com o banco de dados
		
		Pedido pedido = new Pedido();
		pedido.setData(new Date());
		pedido.setCliente(cliente);
		em.persist(pedido); //informações gravadas na tabela
		
		double valorTotal = 0;
		for (Integer produtoId : produtosIds) {
			Produto produto = em.find(Produto.class, produtoId); //procura oelo id e grava em produto
			pedido.getProdutos().add(produto); //adiona dentro da tabela o produto selecionado
			valorTotal += produto.getValor();
		}
		
		pedido.setValorTotal(valorTotal); 
	}
}

