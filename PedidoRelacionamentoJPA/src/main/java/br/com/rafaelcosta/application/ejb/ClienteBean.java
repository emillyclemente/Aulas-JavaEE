package br.com.rafaelcosta.application.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.rafaelcosta.application.model.Cliente;


@Stateless //é criado a transação e depois retorna esperando uma novo requisição > terminou desconecta
public class ClienteBean {

	@PersistenceContext
	private EntityManager em;
	
	public List<Cliente> listar() { //retorna uma lista
		return em.createQuery("SELECT c FROM Cliente c", Cliente.class).getResultList(); //createQuery seleciona todos os item e mostra a classe que vai representar//transforma a entidade em tabela
	}
}
