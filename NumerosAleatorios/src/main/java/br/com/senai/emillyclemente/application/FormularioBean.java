package br.com.senai.emillyclemente.application;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@SuppressWarnings("serial")
@RequestScoped
@Named("formulario")
public class FormularioBean implements Serializable {
	
	private Integer number;
	private Integer minimo;
	private Integer maximo;
	
	private static Random random = new Random(); //Classe que gera os números aleatorios
	
	private List<Integer> numeros = new ArrayList<>(); //Lista que vai guardar os números
	
	public String gerar() {
		
		for (int i = 0; i < number; i++) {
			int n = random.nextInt(maximo - minimo) + minimo + 1; //Método e função que vai pegar os numeros inseridos e de acordo com eles, gerar os numeros aleatorios
			numeros.add(n); //adiciona na variavel n
		}
		
		return null;
	}
	
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public Integer getMinimo() {
		return minimo;
	}
	public void setMinimo(Integer minimo) {
		this.minimo = minimo;
	}
	public Integer getMaximo() {
		return maximo;
	}
	public void setMaximo(Integer maximo) {
		this.maximo = maximo;
	}

	public List<Integer> getNumeros() {
		return numeros;
	}

	public void setNumeros(List<Integer> numeros) {
		this.numeros = numeros;
	}
	

}
