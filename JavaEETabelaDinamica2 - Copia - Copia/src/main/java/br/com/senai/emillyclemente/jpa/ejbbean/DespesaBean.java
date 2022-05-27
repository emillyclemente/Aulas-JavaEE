package br.com.senai.emillyclemente.jpa.ejbbean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import br.com.senai.emillyclemente.model.Despesas;

@Stateless
public class DespesaBean {
	
	@PersistenceContext
	private EntityManager em;
	
	public void excluir(Despesas despesas) {
		despesas = carregar(despesas.getId());
		em.remove(despesas); //remove
	}
	
	public Despesas carregar(int id) {
		return em.find(Despesas.class, id); //procura através do ID
	}
	
	public void atualizar(Despesas despesas) {
		em.merge(despesas); //atualiza uma informação
	}
	
	public void inserir(Despesas despesas) { //receber a tarefa
		em.persist(despesas); //insere uma informação
	}
	 
	
	
}
