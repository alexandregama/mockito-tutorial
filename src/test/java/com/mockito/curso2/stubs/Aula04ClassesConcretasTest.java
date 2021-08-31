package com.mockito.curso2.stubs;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.mockito.curso2.Carrinho;
import com.mockito.curso2.PagamentoService;
import com.mockito.curso2.PayPalHttpService;
import com.mockito.curso2.Produto;

public class Aula04ClassesConcretasTest {

	@Test
	void deveriaFazerUmPagamento() throws Exception {
		PayPalHttpService payPalService = new PayPalHttpService();
		PagamentoService pagamentoService = new PagamentoService(payPalService);
		
		Carrinho carrinho = new Carrinho(pagamentoService);
		
		carrinho.adiciona(new Produto(1l, "Curso Java"));
		
		boolean sucesso = carrinho.fazPagamento();

		assertTrue(sucesso);
	}
	
}
