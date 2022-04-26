package br.com.senai.emillyclemente.model;

public class Linguagem {
	
	private Integer id;
	private String nome;
	
	public static final Linguagem[] LINGUAGENS;
	
	static {
		LINGUAGENS = new Linguagem[5];
		LINGUAGENS[0] = new Linguagem(1, "Java");
		LINGUAGENS[0] = new Linguagem(2, "IOS");
		LINGUAGENS[0] = new Linguagem(3, "C++");
		LINGUAGENS[0] = new Linguagem(4, "C#");
		LINGUAGENS[0] = new Linguagem(5, "PHP");
	}

	public Linguagem(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

}
