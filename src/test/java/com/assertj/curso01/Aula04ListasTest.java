package com.assertj.curso01;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

public class Aula04ListasTest {

	@Test
	void deveriaTestarListaJUnit() throws Exception {
		List<String> linguagens = asList("Java", "Ruby", "Python", "Haskell", "Go", "Erlang", "C", "Rust");
		
		assertEquals(8, linguagens.size());
		assertTrue(linguagens.contains("Ruby"));
		assertFalse(linguagens.contains("PHP"));
	}
	
	@Test
	void deveriaIndicarQueContemJava() throws Exception {
		List<String> linguagens = asList("Java", "Ruby", "Python", "Haskell", "Go", "Erlang", "C", "Rust");
		
		assertThat(linguagens).contains("Java");
	}
	
	@Test
	void deveriaIndicarQueNaoContemPhp() throws Exception {
		List<String> linguagens = asList("Java", "Ruby", "Python", "Haskell", "Go", "Erlang", "C", "Rust");
		
		assertThat(linguagens).doesNotContain("PHP");
	}
	
	@Test
	void deveriaTestarListaAssertJ() throws Exception {
		List<String> linguagens = asList("Java", "Ruby", "Python", "Haskell", "Go", "Erlang", "C", "Rust");
		
		assertThat(linguagens)
			.isNotEmpty()
			.hasSize(8)
			.contains("Ruby")
			.doesNotContain("PHP");
	}
	
	@Test
	void deveriaContemASequenciaDeLinguagens() throws Exception {
		List<String> linguagens = asList("Java", "Ruby", "Python", "Haskell", "Go", "Erlang", "C", "Rust");
		
		assertThat(linguagens).containsSequence("Python", "Haskell", "Go");
	}
	
	@Test
	void deveriaContemASubsequenciaDeLinguagens() throws Exception {
		List<String> linguagens = asList("Java", "Ruby", "Python", "Haskell", "Go", "Erlang", "C", "Rust");
		
		assertThat(linguagens).containsSubsequence("Python", "Haskell", "C");
	}
	
	@Test
	void deveriaIndicarQueNaoContemDuplicados() throws Exception {
		List<String> linguagens = asList("Java", "Ruby", "Python", "Haskell", "Go", "Erlang", "C", "Rust");
		
		assertThat(linguagens).doesNotHaveDuplicates();
	}
	
	@Test
	void deveriaTestarSomenteUmElementoEspecifico() throws Exception {
		List<String> linguagens = asList("Java", "Ruby", "Python", "Haskell", "Go", "Erlang", "C", "Rust");
		
		assertThat(linguagens).element(2).isEqualTo("Python");
		assertThat(linguagens).elements(4, 6).hasSizeLessThan(3);
	}
	
	@Test
	void deveriaValidarTodasAsLinguagensEmQualquerOrdem() throws Exception {
		List<String> linguagens = asList("Java", "Ruby", "Python", "Haskell", "Go", "Erlang", "C", "Rust");
		
		assertThat(linguagens).containsAll(asList("Ruby", "Java", "Python", "Haskell", "Go", "Erlang", "C", "Rust"));
	}
	
	@Test
	void deveriaValidarQueContemAlgumasLinguagensEmQualquerOrdem() throws Exception {
		List<String> linguagens = asList("Java", "Ruby", "Python", "Haskell", "Go", "Erlang", "C", "Rust");
		
		assertThat(linguagens).containsAll(asList("Ruby", "Java", "Python", "Haskell", "Go"));
	}
	
	@Test
	void deveriaValidarTodasAsLinguagensEmDeterminadaOrdem() throws Exception {
		List<String> linguagens = asList("Java", "Ruby", "Python", "Haskell", "Go", "Erlang", "C", "Rust");
		
		assertThat(linguagens).containsExactly("Java", "Ruby", "Python", "Haskell", "Go", "Erlang", "C", "Rust");
	}
	
	@Test
	void deveriaTestarListaEmQualquerOrdem() throws Exception {
		List<String> linguagens = asList("Java", "Ruby", "Python", "Haskell", "Go", "Erlang", "C", "Rust");
		
		assertThat(linguagens).containsExactlyInAnyOrder("Ruby", "Java", "Python", "Haskell", "Go", "Erlang", "C", "Rust");
	}
	
}