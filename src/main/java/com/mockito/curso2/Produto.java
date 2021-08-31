package com.mockito.curso2;

public class Produto {

	private Long id;
	
	private String nome;

	public Produto(Long id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}
	
	public Long getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	
}
