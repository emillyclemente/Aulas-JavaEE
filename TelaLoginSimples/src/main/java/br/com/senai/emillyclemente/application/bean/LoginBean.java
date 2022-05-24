package br.com.senai.emillyclemente.application.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class LoginBean implements Serializable {
	
	private String nome;
	private String senha;
	
	@PostConstruct //Para chamar informações do banco de dados ou mémoria assim que o bean for chamado
	public void onCreate() {
		System.out.println("Bean criado");
	}
	
	@PreDestroy //Executa esse método antes do bean ser destruido
	public void onDestroy() {
		System.out.println("Bean será destruido");
	}
	
	public String doLogin() {
		if("abc".equals(nome) && "123".equals(senha)) { //validação da senha e do nome de login. //equals é a mesma coisa que "==" para string
			return "sucesso"; //Outcome, ele vai para outra página
		}
		return null; //Quando retorna null ele recarrega a mesma página
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
}
