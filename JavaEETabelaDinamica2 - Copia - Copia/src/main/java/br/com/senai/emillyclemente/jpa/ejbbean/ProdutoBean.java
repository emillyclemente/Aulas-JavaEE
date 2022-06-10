package br.com.senai.emillyclemente.jpa.ejbbean;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.senai.emillyclemente.model.Produtos;


@Stateless
public class ProdutoBean {
		
	@PersistenceContext //JPA faz tudo por trás, responsável pela conexão com o banco de dados
	private EntityManager em;
	
	public List<Produtos> listar() {
		return em.createQuery("SELECT p FROM Produtos p", Produtos.class).getResultList(); //Listar os produtos que estao no banco de dados
	}
	

}
