package com.assertj.curso02;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class Aula04SatistyTest {

	@Test
	void deveriaTestarCadaElementoDeFormaCretina() throws Exception {
		List<String> linguagens = Arrays.asList("Java", "Ruby", "Python", "Erlang");
		
		assertThat(linguagens.get(0)).hasSizeGreaterThan(3);
		assertThat(linguagens.get(1)).hasSizeGreaterThan(3);
		assertThat(linguagens.get(2)).hasSizeGreaterThan(3);
		assertThat(linguagens.get(3)).hasSizeGreaterThan(3);
		
		assertThat(linguagens.get(0)).isNotEmpty();
		assertThat(linguagens.get(1)).isNotEmpty();
		assertThat(linguagens.get(2)).isNotEmpty();
		assertThat(linguagens.get(3)).isNotEmpty();
		
		assertThat(linguagens.get(0)).doesNotContainAnyWhitespaces();
		assertThat(linguagens.get(1)).doesNotContainAnyWhitespaces();
		assertThat(linguagens.get(2)).doesNotContainAnyWhitespaces();
		assertThat(linguagens.get(3)).doesNotContainAnyWhitespaces();
	}
	
	@Test
	void deveriaTestarCadaElementoDeFormaMelhor() throws Exception {
		List<String> linguagens = Arrays.asList("Java", "Ruby", "Py thon", "Erlang");
		
		linguagens.forEach(linguagem -> assertThat(linguagem).hasSizeGreaterThan(3));
		linguagens.forEach(linguagem -> assertThat(linguagem).isNotEmpty());
		linguagens.forEach(linguagem -> assertThat(linguagem).doesNotContainAnyWhitespaces());
	}
	
	@Test
	void deveriaTestarCadaElementoNoEstadoDaArte() throws Exception {
		List<String> linguagens = Arrays.asList("Java", "Ruby", "Py thon", "Erlang");
		
		assertThat(linguagens).allSatisfy(linguagem -> {
			assertThat(linguagem).hasSizeGreaterThan(3);
			assertThat(linguagem).isNotEmpty();
			assertThat(linguagem).doesNotContainAnyWhitespaces();
		});
	}
	
	@Test
	void deveriaTestarAlgumElementoSatisfacaACondicao() throws Exception {
		List<String> linguagens = Arrays.asList("Java", "Ruby", "Py thon", "Erlang");
		
		assertThat(linguagens).anySatisfy(linguagem -> {
			assertThat(linguagem).hasSizeGreaterThan(3);
			assertThat(linguagem).isNotEmpty();
			assertThat(linguagem).doesNotContainAnyWhitespaces();
		});
	}
	
}
