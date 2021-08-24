package com.assertj.curso02;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.function.Predicate;

import org.assertj.core.api.Condition;
import org.junit.jupiter.api.Test;

public class Aula02ListasComMatchTest {

	@Test
	void deveriaTestarListaComAlgumaCondicaoAssertJ() throws Exception {
		List<String> linguagens = asList("Java", "Ruby", "Python", "Haskell", "Go", "Erlang", "C", "Rust");
		
		Predicate<String> condicao = new Predicate<String>() {

			@Override
			public boolean test(String nome) {
				return nome.length() >= 1; //2
			}
		};
		
		assertThat(linguagens).allMatch(condicao);
	}
	
	@Test
	void deveriaTestarListaComAlgumaCondicaoAssertJFormaDecente() throws Exception {
		List<String> linguagens = asList("Java", "Ruby", "Python", "Haskell", "Go", "Erlang", "C", "Rust");
		
		Predicate<String> condicao = (String nome) -> nome.length() >= 1;
		
		assertThat(linguagens).allMatch(condicao);
	}
	
	@Test
	void deveriaTestarListaComAlgumaCondicaoAssertJFormaMaisDecente() throws Exception {
		List<String> linguagens = asList("Java", "Ruby", "Python", "Haskell", "Go", "Erlang", "C", "Rust");
		
		Predicate<String> condicao = nome -> nome.length() >= 1;
		
		assertThat(linguagens).allMatch(condicao);
	}
	
	@Test
	void deveriaTestarListaComAlgumaCondicaoAssertJFormaMaisMalandrinha() throws Exception {
		List<String> linguagens = asList("Java", "Ruby", "Python", "Haskell", "Go", "Erlang", "C", "Rust");
		
		assertThat(linguagens).allMatch(nome -> nome.length() >= 1);
	}
	
	@Test
	void deveriaValidarQueTodosTemTamanhoMaiorQue1() throws Exception {
		List<String> linguagens = asList("Java", "Ruby", "Python", "Haskell", "Go", "Erlang", "C", "Rust");
		
		Predicate<String> tamanhoMaiorQue1 = nome -> nome.length() >= 1;
		
		assertThat(linguagens).allMatch(tamanhoMaiorQue1);
	}
	
	@Test
	void deveriaTerPeloMenos1ElementoComMatch() throws Exception {
		List<String> linguagens = asList("Java", "Ruby", "Python", "Haskell", "Go", "Erlang", "C", "Rust");
		
		assertThat(linguagens).anyMatch(nome -> nome.length() == 1);
	}
	

	@Test
	void deveriaIndicarQueTodosTemTamanhoMaiorQue1() throws Exception {
		List<String> linguagens = asList("Java", "Ruby", "Python", "Haskell", "Go", "Erlang", "C", "Rust");
		
		Condition<String> tamanhoMaiorQue1 = new Condition<>(string -> string.length() >= 1, "tamanho maior que 1");  
		
		assertThat(linguagens).are(tamanhoMaiorQue1);
	}

}