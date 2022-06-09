package br.com.senai.emillyclemente.application;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@SuppressWarnings("serial")
@Named
@RequestScoped  //Ele é iniciado quando uma requisição é realizada, após a resposta, o tempo de vida do bean acaba

public class PageBean implements Serializable {
	
	private String page;
	
	public enum Pages {
		page_a, page_b; //Enum das páginas
	}
	
	

	public String getPage() { 
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}
	
	
	public Pages goTo() {  //Método para validação de qual página o usuário quer ir, caso for "a" ele direciona para a página "a", se for "b" para a página "b"
		
		if("a".equals(page)) {
			return Pages.page_a;
			
		}else if("b".equals(page)) { //equals é == para string
			return Pages.page_b;
		}else {
			return null;
		}
	}
}
