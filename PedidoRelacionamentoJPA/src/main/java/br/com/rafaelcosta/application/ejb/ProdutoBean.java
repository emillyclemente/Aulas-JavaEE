package br.com.rafaelcosta.application.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.rafaelcosta.application.model.Produto;


@Stateless  //Bean igual o request scopped, ele é iniciado quando uma requisição é realizada, após a resposta, o tempo de vida do bean acaba
public class ProdutoBean {

	@PersistenceContext //JPA faz tudo por trás, responsável pela conexão com o banco de dados
	private EntityManager em;
	
	public List<Produto> listar() {
		return em.createQuery("SELECT p FROM Produto p", Produto.class).getResultList();
	}
}

//Lista todos os produtos cadastrados
