package com.assertj.curso01;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class Aula02AssertionsFluentesTest {

	@Test
	void deveriaTestarPartesDoNomeJUnit() throws Exception {
		String nome = "Alexandre Gama";
		
		assertTrue(nome.startsWith("Alexandre"));
		assertTrue(nome.endsWith("Gama"));
		assertTrue(nome.contains("x"));
	}
	
	@Test
	void deveriaTestarPartesDoNomeAssertJ() throws Exception {
		String nome = "Alexandre Gama";
		
		assertThat(nome).startsWith("Alexandre").endsWith("Gama").contains("x");
	}
	
	@Test
	void deveriaValidarTodasAsInformacoesDoJoaoDeUmaVez() throws Exception {
		Pessoa joao = new Pessoa("Joao", 30l, "jojo");
		
		//entender como usar Tuple
		assertThat(joao).extracting("nome", "idade", "apelido").contains("Joao", 30l, "jojo");
	}
	
}


class Pessoa {
	
	private String nome;
	
	private Long idade;
	
	private String apelido;

	public Pessoa(String nome, Long idade, String apelido) {
		super();
		this.nome = nome;
		this.idade = idade;
		this.apelido = apelido;
	}
	
	public String getNome() {
		return nome;
	}
	
	public Long getIdade() {
		return idade;
	}
	
	public String getApelido() {
		return apelido;
	}
	
}