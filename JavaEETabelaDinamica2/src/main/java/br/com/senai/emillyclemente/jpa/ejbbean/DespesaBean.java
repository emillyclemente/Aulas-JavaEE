package br.com.senai.emillyclemente.jpa.ejbbean;

//bean da lógica de négocios
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import br.com.senai.emillyclemente.model.Despesas;

@Stateless //tipo de bean EJB
public class DespesaBean {
	
	@PersistenceContext  //jpa faz tudo por trás, responsável pela conexão com o banco de dados
	private EntityManager em; //Classe da JPA que faz a conexão com o banco, tem sempre que ligar o "em" as váriaveis para ações, assim ele mexe no banco de dados
	
	public void excluir(Despesas despesas) {
		despesas = carregar(despesas.getId());
		em.remove(despesas); //remove no banco de dados tambem, pelo getID que carrega as informações para depois excluir no banco de dados tambem
	}
	
	public Despesas carregar(int id) {
		return em.find(Despesas.class, id); //procura através do ID e carrega as informações da tabela, retorna com o espaço preenchido 
	}
	
	public void atualizar(Despesas despesas) {
		em.merge(despesas); //atualiza uma informação
	}
	
	public void inserir(Despesas despesas) { //receber a tarefa
		em.persist(despesas); //insere uma informação
	}
	 
	
	
}
