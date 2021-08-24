package com.assertj.curso03;

import static org.assertj.core.api.Assertions.*;

import java.util.function.Consumer;

import org.assertj.core.api.Assertions;
import org.assertj.core.description.Description;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

//https://assertj.github.io/doc/#assertj-core-assertion-description-consumer

public class Aula01RelatorioDeTesteCustomizadoTest {

	private static StringBuilder relatorio;

	@BeforeAll
	public static void beforeAll() {
		relatorio = new StringBuilder(String.format("Assertions:%n"));
		Consumer<Description> descriptionConsumer = desc -> relatorio.append(String.format("-- %s%n", desc));
		
		Assertions.setDescriptionConsumer(descriptionConsumer);
	}
	
	@Test
	void deveriaValidarONome() throws Exception {
		String nome = "Alexandre Gama";
		
		assertThat(nome).as("deveria conter a palavra Alexandre").contains("Alexandre");
	}
	
	@Test
	void deveriaValidarOSobrenome() throws Exception {
		String nome = "Alexandre Gama";
		
		assertThat(nome).as("deveria conter a palavra Gama").contains("Gama");
	}
	
	@AfterAll
	public static void afterAll() {
		String relatorioCompleto = relatorio.toString();
		System.out.println(relatorioCompleto);
	}
	
}
