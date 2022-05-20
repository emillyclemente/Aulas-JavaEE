package br.com.senai.allanyconsoni.application.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Named;
import br.com.senai.allanyconsoni.model.Despesas;
@SuppressWarnings("serial") //tira o aviso de cuidado do Eclipse
@SessionScoped //
@Named("tabela") //

public class TabelaBean implements Serializable{

	
	private List<Despesas> despesas = new ArrayList<>();//recebe a lista chamada 'despesa' e grava na tabela
	
	//cria novo objeto dentro da tabela 
	public String inserir() {
		Despesas d = new Despesas();
		d.setEdit(true);
		despesas.add(d);
		return null;
	}
	//revove a despesa dentro da tabela
	public String excluir(Despesas despesa) {
		despesas.remove(despesa);
		return null;
	}
	//muda a forma que manipula a tabela
	public String editar(Despesas despesa) { 
		despesa.setEdit(true);
		return null;
	}
	//muda a forma que manipula a tabela
	public String gravar(Despesas despesa) { 
		despesa.setEdit(false);
		return null;
	}
	//mostra todas as depesas da tabela
	public List<Despesas> getDespesas(){
		return despesas;
	}
	
}
