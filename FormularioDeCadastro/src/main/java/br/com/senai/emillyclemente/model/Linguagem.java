package br.com.senai.emillyclemente.model;

public class Linguagem {
	
	private Integer id;
	private String nome;
	
	public static final Linguagem[] LINGUAGENS; //Inicialização da constante das Linguagens
	
	static {
		LINGUAGENS = new Linguagem[5];
		LINGUAGENS[0] = new Linguagem(1, "Java"); //Colocando cada linguagem dentro de um espaço da constante
		LINGUAGENS[1] = new Linguagem(2, "IOS");
		LINGUAGENS[2] = new Linguagem(3, "C++");
		LINGUAGENS[3] = new Linguagem(4, "C#");
		LINGUAGENS[4] = new Linguagem(5, "PHP");
	}
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}



	public Linguagem(Integer id, String nome) { //Parametros do construtor
		this.id = id;
		this.nome = nome;
	}

}
