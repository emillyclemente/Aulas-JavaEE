package br.com.senai.laisyukari.application.bean;      //bean para interface

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
	
	private List<Despesa> despesaList = new ArrayList<>();   //list para gravar tabela, para receber lista
	private ListDataModel<Despesa> despesa = new ListDataModel<>(despesaList); //utilizado pelo jsf para construir a lista 
	
	public String inserir() {                             //inser��o de crud em cima da lista, para novo objeto e adiciona ana lista
		Despesa d = new Despesa();
		d.setEdit(true);
		despesaList.add(d);		
		return null;
	}
	
	public String excluir(Despesa despesa) {         //remo��o da despesa da lista 
		despesaList.remove(despesa);
		return null;
	}
	
	public String editar(Despesa despesa) {   //unica fun�ao ser� manipular a informa��o
		despesa.setEdit(true);                // true para renderizar novo bot�o
		return null;
	}
	
	public String gravar(Despesa despesa) {  
		despesa.setEdit(false);
		return null;
	}
	
	public ListDataModel<Despesa> getDespesa(){        //get captura informa��o para o jsf
		return despesa;                                //retorno de despesa por conta do vinculo com o jsf, o qual utiliza para fazer a jun��o da tabela
	}
}

