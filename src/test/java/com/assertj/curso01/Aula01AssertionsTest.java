package com.assertj.curso01;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class Aula01AssertionsTest {

	@Test
	void deveriaTestarONomeJUnit() throws Exception {
		String nome = "Alexandre Gama";
		
		assertEquals("Alexandre Gama", nome);
	}
	
	@Test
	void deveriaTestarONomeAssertJ() throws Exception {
		String nome = "Alexandre Gama";
		
		assertThat(nome).isEqualTo("Alexandre Gama");
		assertThat(nome).isNotBlank();
		assertThat(nome).isNotEqualTo("Jose");
	}

	@Test
	void deveriaTestarONomeComMensagemJUnit() throws Exception {
		String nome = "Alexandre Gam";
		
		assertEquals("Alexandre Gama", nome, "deveria ser Alexandre Gama");
	}	
	
	@Test
	void deveriaTestarONomeComMensagemAssertJ() throws Exception {
		String nome = "Alexandre Gam";
		
		assertThat(nome).as("deveria ser Alexandre Gama").isEqualTo("Alexandre Gama");
	}	
	
	@Test
	void deveriaTestarONomeSemMensagemUsandoBooleanDeFormaDeselegante() throws Exception {
		String nome = "Alexandre Gam";
		
		assertThat(nome.equals("Alexandre Gama")).isTrue();
	}	
	
	@Test
	void deveriaTestarONomeComMensagemUsandoBoolean() throws Exception {
		String nome = "Alexandre Gam";
		
		assertThat(nome.equals("Alexandre Gama")).as("nome deveria ser Alexandre Gana").isTrue();
	}	
	
	@Test
	void deveriaTestarSeContainJUnit() throws Exception {
		String nome = "Alexandre Gama";
		
		assertTrue(nome.contains("Gama"));
		assertFalse(nome.contains("Joao"));
	}
	
	@Test
	void deveriaTestarSeContainAssertJFormaDeselegante() throws Exception {
		String nome = "Alexandre Gama";
		
		assertThat(nome.contains("Gama")).isTrue();
		assertThat(nome.contains("Joao")).isFalse();
	}
	
	@Test
	void deveriaTestarSeContainAssertJFormaElegante() throws Exception {
		String nome = "Alexandre Gama";

		assertThat(nome).contains("Gama");
	}
	
	
}
