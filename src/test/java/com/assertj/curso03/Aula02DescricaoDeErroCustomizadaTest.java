package com.assertj.curso03;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

//https://assertj.github.io/doc/#assertj-core-overriding-error-message
public class Aula02DescricaoDeErroCustomizadaTest {

	@Test
	void deveriaTestarONome() throws Exception {
		String nome = "Alexandre Gam";
		
		assertThat(nome).contains("Gama");
	}
	
	@Test
	void deveriaTestarONomeMostrandoDescricao() throws Exception {
		String nome = "Alexandre Gam";
		
		assertThat(nome).as("O nome realmente não pode ser diferente de Gama").contains("Gama");
	}
	
	@Test
	void deveriaTestarONomeMostrandoMensagemDeErroCustomizada() throws Exception {
		String nome = "Alexandre Gam";
		
		assertThat(nome).withFailMessage("O nome realmente não pode ser diferente de Gama").contains("Gama");
	}
	
}
