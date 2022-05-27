package br.com.rafaelcosta.jpa.jsfbean;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.rafaelcosta.jpa.ejbbean.TarefaBean;
import br.com.rafaelcosta.jpa.model.Tarefa;

@Named("form")
@RequestScoped 
public class FormBean implements Serializable {
	
	@EJB
	private TarefaBean tarefaBean; //Criação de váriavel que vai conectar com o EJB

	@Inject
	private FacesContext context; //Classe do EJB, já está pronta. //Context pega as informações e ações do formulário.
	
	private UIComponent searchInputText; //Classe do EJB
	
	private Integer tarefaId;
	
	private Tarefa tarefa;
	
	//Ajax é um JavaScript Express, escolhe onde se quer carregar os dados, não precisa recarregar a página inteira, ele renderiza só  a linha que é necessária.
	public void gravar(AjaxBehaviorEvent event) { //Quando gravar, ele vai chamar o ajax, e guardar as informações em event. Validar, caso não tenha uma tarefa ele grava
		if(tarefa.getId()==null) {
			tarefaBean.inserir(tarefa);
		}else {
			tarefaBean.atualizar(tarefa); //Se a tarefa existir, ele atualiza e coloca por cima da que ja tem.
		}		
	}
	
	public void pesquisar(AjaxBehaviorEvent event) { //Recebe o evento do ajax, e passa o id da tarefaId para tarefa
		tarefa = tarefaBean.carregar(tarefaId);
		
		if(tarefa == null) {
			context.addMessage(searchInputText.getClientId(context), //Adiciona uma mensagem ao context
					new FacesMessage("Tarefa n�o encontrada"));
		}
		tarefaId = null;		
	}
	
	public void excluir(AjaxBehaviorEvent event) { //Excluir a tarefa, chmar o método de excluir, pegar a tarefa apagar e deixar nulo
		tarefaBean.excluir(tarefa);
		tarefa = null;
	}
	
	public Tarefa getTarefa() { //Se tarefa estiver nulo, não existir, cria uma tarefa nova. Se existir, retorna ela.
		if(tarefa==null) {
			tarefa = new Tarefa();
		}
		return tarefa;
	}
 
	public UIComponent getSearchInputText() {
		return searchInputText;
	}

	public void setSearchInputText(UIComponent searchInputText) {
		this.searchInputText = searchInputText;
	}

	public Integer getTarefaId() {
		return tarefaId;
	}

	public void setTarefaId(Integer tarefaId) {
		this.tarefaId = tarefaId;
	}
	
	
	
}
