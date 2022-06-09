package br.com.rafaelcosta.application.bean;

//Formata o valor, e converte em dinheiro

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Locale;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped
public class FormatterBean implements Serializable {

	private static final Locale LOCALE_BR = new Locale("pt", "BR"); //Localização e a lingua
	
	public String formatarMoeda(double valor) {
		NumberFormat nf = NumberFormat.getCurrencyInstance(LOCALE_BR); //NumberFormat formata os números conforme o tipo de moeda e valor escolhidos
		return nf.format(valor); //retorno do valor com R$ de real
	}
}
