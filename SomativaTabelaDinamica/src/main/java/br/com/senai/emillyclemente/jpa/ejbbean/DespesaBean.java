package br.com.senai.emillyclemente.jpa.ejbbean;

//EJB que cuida da lógca de negocios
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import br.com.senai.emillyclemente.model.Despesas;

@Stateless //Bean igual o request scopped, ele é iniciado quando uma requisição é realizada, após a resposta, o tempo de vida do bean acaba
public class DespesaBean {
	
	@PersistenceContext  //JPA faz tudo por trás, responsável pela conexão com o banco de dados
	private EntityManager em; //Classe da JPA que faz a conexão com o banco, tem sempre que ligar o "em" nas váriaveis para ações, assim ele mexe no banco de dados
	
	public void excluir(Despesas despesas) {
		despesas = carregar(despesas.getId());
		em.remove(despesas); //Remove no banco de dados tambem, pelo getID que carrega as informações para depois excluir no banco de dados
	}
	
	public Despesas carregar(int id) {
		return em.find(Despesas.class, id); //Procura através do ID e carrega as informações da tabela, retorna com o espaço preenchido 
	}
	
	public void atualizar(Despesas despesas) {
		em.merge(despesas); //Atualiza uma informação
	}
	
	public void inserir(Despesas despesas) { //Recebe a despesa
		em.persist(despesas); //Insere uma informação
	}
	 
	
	
}
