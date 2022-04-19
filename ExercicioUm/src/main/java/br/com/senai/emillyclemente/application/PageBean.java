package br.com.senai.emillyclemente.application;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.Flash;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class PageBean implements Serializable {
	
	private StringBuilder texto;

	@Inject
	private Flash flash;
	
	public String inverter() {
		
		flash.put("textoInvertido", texto);
		return "form";
	}

	public StringBuilder getTexto() {
		texto.reverse();
		return texto;
	}

	public void setTexto(StringBuilder texto) {
		this.texto = texto;
	}
	

}
