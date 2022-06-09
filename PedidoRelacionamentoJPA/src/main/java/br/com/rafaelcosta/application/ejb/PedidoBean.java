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


@Stateless //Bean igual o request scopped, ele é iniciado quando uma requisição é realizada, após a resposta, o tempo de vida do bean acaba
public class PedidoBean {

	@PersistenceContext
	private EntityManager em;
	
	public List<Pedido> listar() { //Lista todos os pedidos realizados
		return em.createQuery("SELECT p FROM Pedido p", Pedido.class).getResultList();
	}
	
	public void pagar(Integer pedidoId, String tipo) { //Recebe o ID e o tipo de pagamento escolhido
		TipoPagamento tipoPagamento = TipoPagamento.valueOf(tipo);
		Pedido pedido = em.find(Pedido.class, pedidoId); //Pesquisa o pedido através do ID
		
		Pagamento pagamento = new Pagamento();
		pagamento.setTipoPagto(tipoPagamento); //Pagamento do pedido e o tipo de pagamento
		em.persist(pagamento);
		
		pedido.setPagamento(pagamento); // atualização no banco de dados do tipo de pagamento daquele pedido
	}
	
	public void excluir(Integer pedidoId) {
		Pedido pedido = em.find(Pedido.class, pedidoId); //Busca o pedido através do ID e remove ele
		em.remove(pedido);
	}
	
	public void cadastrar(Integer clienteId, Integer[] produtosIds) throws Exception { 
		Cliente cliente = em.find(Cliente.class, clienteId); //Busca o ID do cliente para fazer a conexão com o banco de dados
		
		Pedido pedido = new Pedido();
		pedido.setData(new Date());
		pedido.setCliente(cliente);
		em.persist(pedido); //Linkagem das tabelas, com informações de data e cliente dentro da tabela pedido
		
		double valorTotal = 0;
		for (Integer produtoId : produtosIds) {
			Produto produto = em.find(Produto.class, produtoId); //Busca o produto pelo ID 
			pedido.getProdutos().add(produto); //Adiciona dentro da tabela o produto que foi encontrado pelo ID
			valorTotal += produto.getValor();
		}
		
		pedido.setValorTotal(valorTotal); //Valor total do pedido
	}
}

