package br.com.senai.emillyclemente.application;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@SuppressWarnings("serial")
@Named
@RequestScoped //Ele é iniciado quando uma requisição é realizada, após a resposta, o tempo de vida do bean acaba
public class IndexBean implements Serializable {

	public String getMensagem() { //Método para mostrar esta mensagem no xhtm quando ele for chamado
		
		return "Texto vindo do Bean";
	}
}
