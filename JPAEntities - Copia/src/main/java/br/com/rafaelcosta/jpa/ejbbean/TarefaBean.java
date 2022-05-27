package br.com.rafaelcosta.jpa.ejbbean;
//bean da lógica de négocios
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.rafaelcosta.jpa.model.Tarefa;

@Stateless //tipo de bean EJB
public class TarefaBean {

	@PersistenceContext //jpa faz tudo por trás
	private EntityManager em; //Classe da JPA que faz a conexão com o banco, tem sempre que ligar o "em" as váriaveis para ações, assim ele mexe no banco de dados
	
	public void inserir(Tarefa tarefa) { //receber a tarefa
		em.persist(tarefa); //insere uma informação
	}
	
	public void atualizar(Tarefa tarefa) {
		em.merge(tarefa); //atualiza uma informação
	}
	
	public void excluir(Tarefa tarefa) {
		tarefa = carregar(tarefa.getId());
		em.remove(tarefa); //remove
	}
	
	public Tarefa carregar(int id) {
		return em.find(Tarefa.class, id); //procura através do ID
	}
}
