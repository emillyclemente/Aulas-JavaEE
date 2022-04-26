package main.java.br.com.senai.emillyclemente.application;
import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.Flash;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class PageBean implements Serializable {
	
	String texto;
	String textoInvertido;
	
	@Inject
	private Flash flash;
	
	
	public String getTexto() {
		return texto;
	} 
	
	public void setTexto(String texto) {
		this.texto = texto;
	}


	public String getTextoInvertido() {
		return textoInvertido;
	}

	public void setTextoInvertido(String textoInvertido) {
		this.textoInvertido = textoInvertido;
	}


	public String inverter() {
		textoInvertido = new StringBuilder(texto).reverse().toString();
		flash.put("textoInvertido", textoInvertido);
		return "form?faces-redirect=true";
	}
	

}

