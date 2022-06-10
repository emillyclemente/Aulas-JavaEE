package br.com.senai.emillyclemente.application;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.senai.emillyclemente.model.Endereco;
import br.com.senai.emillyclemente.model.Estado;
import br.com.senai.emillyclemente.model.Interesse;
import br.com.senai.emillyclemente.model.Pessoa;
import br.com.senai.emillyclemente.model.Telefone;
import br.com.senai.emillyclemente.util.InicializacaoConstantes;

@SuppressWarnings("serial")
@SessionScoped
@Named("cadastro")
public class CadastroBean implements Serializable{
	private Pessoa pessoa;

	public Pessoa getPessoa() { //Para criar e chamar os que não existem, criando um novo
		if(pessoa == null) {
			pessoa = new Pessoa();
			pessoa.setEnderecoResidencial(new Endereco());
			pessoa.getEnderecoResidencial().setEstado(new Estado());
			pessoa.setEnderecoComercial(new Endereco());
			pessoa.getEnderecoComercial().setEstado(new Estado());
			pessoa.setTelefoneResidencial(new Telefone());
			pessoa.setTelefoneCelular(new Telefone());
			pessoa.setTelefoneComercial(new Telefone());
		}
		return pessoa;
	}


	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;

}
	public List<Estado> getEstados() {
		return InicializacaoConstantes.ESTADOS; //Chamando a constante de estados
	}
	
	public List<Interesse> getInteresses() {
		return InicializacaoConstantes.INTERESSES; //Chamando a constante de interesses
	}


}
