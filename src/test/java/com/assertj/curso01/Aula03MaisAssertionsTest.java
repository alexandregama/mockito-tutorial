package com.assertj.curso01;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class Aula03MaisAssertionsTest {

	
	@Test
	void deveriaConterEspacos() throws Exception {
		String nome = "Alexandre Gama";
		
		assertThat(nome).containsWhitespaces();
	}
	
	@Test
	void naoDeveriaConterEspacos() throws Exception {
		String nome = "AlexandreGama";
		
		assertThat(nome).doesNotContainAnyWhitespaces();
	}
	
	@Test
	void deveriaValidarSubsequencia() throws Exception {
		String nome = "Alexandre Gama";
		
		assertThat(nome).containsSequence("dre");
	}
	
	@Test
	void deveriaConterUmPadrao() throws Exception {
		String nome = "Alexandre Gama";
		
		assertThat(nome).containsPattern(".ama");
	}
	
	@Test
	void naoDeveriaFinalizarComGama() throws Exception {
		String nome = "Alexandre";
		
		assertThat(nome).doesNotStartWith("Joao");
		assertThat(nome).doesNotEndWith("Gama");
	}
	
	@Test
	void deveriaTerOmesmoTamanho() throws Exception {
		String primeiroSobrenome = "Gama";
		String segundoSobrenome = "Lima";
		
		assertThat(primeiroSobrenome).hasSameSizeAs(segundoSobrenome);
	}
	
	@Test
	void deveriaTestarOSizeDeDiferentesFormas() throws Exception {
		String nome = "Alexandre";
		String sobrenome = "Gama";
		
		assertThat(nome).hasSize(9);
		assertThat(nome).hasSizeGreaterThanOrEqualTo(5);
		assertThat(sobrenome).hasSizeLessThan(5);
		assertThat(sobrenome).hasSizeBetween(2, 4);
	}
	
	@Test
	void deveriaEstarEmLowercase() throws Exception {
		String nome = "alexandre";
		
		assertThat(nome).isLowerCase();
	}
	
	
}
