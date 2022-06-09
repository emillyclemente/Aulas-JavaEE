package br.com.senai.laisyukari.application.bean;      // É o Bean para interface

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Named;

import br.com.senai.laisyukari.application.model.Despesa;

@SuppressWarnings("serial")
@RequestScoped
@Named("tabela")

public class TabelaBean implements Serializable{ 
	
	private List<Despesa> despesaList = new ArrayList<>();   //É a lista para gravar tabela, para receber lista
	private ListDataModel<Despesa> despesa = new ListDataModel<>(despesaList); // É utilizado pelo JSF para construir a lista 
	
	public String inserir() //Inserção do CRUD em cima da lista, para um novo objeto e adiciona na lista
		Despesa d = new Despesa();
		d.setEdit(true);
		despesaList.add(d);		
		return null;
	}
	
	public String excluir(Despesa despesa) {   //Remove a despesa da lista 
		despesaList.remove(despesa);
		return null;
	}
	
	public String editar(Despesa despesa) {   //Unica funçao será manipular a informação
		despesa.setEdit(true);                // True para renderizar um novo botão
		return null;
	}
	
	public String gravar(Despesa despesa) {  
		despesa.setEdit(false);
		return null;
	}
	
	public ListDataModel<Despesa> getDespesa(){        //O Get captura uma nova informação para o jsf
		return despesa;                                //Retorno de despesa por conta do vinculo com o JSF, o qual utiliza ela para fazer a junção da tabela
	}
}

