package br.com.rafaelcosta.application.bean;

//formata o valor, converte

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Locale;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped
public class FormatterBean implements Serializable {

	private static final Locale LOCALE_BR = new Locale("pt", "BR"); //localização e lingua
	
	public String formatarMoeda(double valor) {
		NumberFormat nf = NumberFormat.getCurrencyInstance(LOCALE_BR); //NumberFormat formata os numeros conforme o tipo de moeda e valor
		return nf.format(valor); //retoorno do valor com R$
	}
}
