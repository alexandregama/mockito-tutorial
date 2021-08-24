package com.assertj.curso03;

import static org.assertj.core.api.Assertions.*;

import java.util.function.Supplier;

import org.junit.jupiter.api.Test;

//https://assertj.github.io/doc/#assertj-core-lazy-error-message
public class Aula03MensagemErroLazyTest {

	@Test
	void deveriaTestarONomeComUmaMensagemQueVemDeOutroCantoDemorado() throws Exception {
		String nome = "Alexandre Ga";
		
		assertThat(nome).withFailMessage(new Pagamento().mensagemErro()).contains("Gama");
	}
	
	@Test
	void deveriaTestarONomeComUmaMensagemQueVemDeOutroCantoDemoradoQuandoTesteEstaCorreto() throws Exception {
		String nome = "Alexandre Gama";
		
		assertThat(nome).withFailMessage(new Pagamento().mensagemErro()).contains("Gama");
	}
	
	@Test
	void deveriaTestarONomeComUmaMensagemQueVemDeOutroCantoDemoradoQuandoTesteEstaCorretoFormaBonita() throws Exception {
		String nome = "Alexandre Gama";
		
		Supplier<String> mensagemErro = new Supplier<String>() {

			@Override
			public String get() {
				return new Pagamento().mensagemErro();
			}
		};
		
		assertThat(nome).withFailMessage(mensagemErro).contains("Gama");
	}
	
	@Test
	void deveriaTestarONomeComUmaMensagemQueVemDeOutroCantoDemoradoQuandoTesteEstaCorretoFormaElegante() throws Exception {
		String nome = "Alexandre Gama";
		
		Supplier<String> mensagemErro = () -> new Pagamento().mensagemErro();
		
		assertThat(nome).withFailMessage(mensagemErro).contains("Gama");
	}
	
	@Test
	void deveriaTestarONomeComUmaMensagemQueVemDeOutroCantoDemoradoQuandoTesteEstaCorretoFormaMaisElegante() throws Exception {
		String nome = "Alexandre Gama";
		
		assertThat(nome).withFailMessage(() -> new Pagamento().mensagemErro()).contains("Gama");
	}
	
}

class Pagamento {
	
	public String mensagemErro() {
		try {
			Thread.sleep(5000);
			return "serviço fora do ar";
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
