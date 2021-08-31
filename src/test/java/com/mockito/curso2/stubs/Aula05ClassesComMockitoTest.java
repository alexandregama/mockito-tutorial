package com.mockito.curso2.stubs;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import com.mockito.curso2.Carrinho;
import com.mockito.curso2.PagamentoService;
import com.mockito.curso2.PayPalHttpService;
import com.mockito.curso2.Produto;

public class Aula05ClassesComMockitoTest {

	@Test
	void deveriaFazerUmPagamentoComMock() throws Exception {
		PayPalHttpService payPalHttpService = mock(PayPalHttpService.class);
		PagamentoService pagamentoService = new PagamentoService(payPalHttpService);
		
		Carrinho carrinho = new Carrinho(pagamentoService);
		carrinho.adiciona(new Produto(1l, "Curso Java"));
		
		when(payPalHttpService.authorize("gama", "12345")).thenReturn(true);
		when(payPalHttpService.enviaPaginaPagamento(anyList())).thenReturn(true);
		
		boolean sucesso = carrinho.fazPagamento();

		assertTrue(sucesso);		
	}
	
	@Test
	void deveriaFazerUmPagamentoComAutenticacaoMaisGenerica() throws Exception {
		PayPalHttpService payPalHttpService = mock(PayPalHttpService.class);
		PagamentoService pagamentoService = new PagamentoService(payPalHttpService);
		
		Carrinho carrinho = new Carrinho(pagamentoService);
		carrinho.adiciona(new Produto(1l, "Curso Java"));
		
		when(payPalHttpService.authorize(anyString(), anyString())).thenReturn(true);
		when(payPalHttpService.enviaPaginaPagamento(anyList())).thenReturn(true);
		
		boolean sucesso = carrinho.fazPagamento();
		
		assertTrue(sucesso);		
	}
	
	@Test
	void naoDeveriaPagarQuandoAAutorizacaoFalhar() throws Exception {
		PayPalHttpService payPalHttpService = mock(PayPalHttpService.class);
		PagamentoService pagamentoService = mock(PagamentoService.class);
		
		Carrinho carrinho = new Carrinho(pagamentoService);
		carrinho.fazPagamento();
		
		when(payPalHttpService.authorize(anyString(), anyString())).thenReturn(false);
		
		verify(pagamentoService, never()).paga(anyList());
	}
	
	@Test
	void deveriaLancarAcessoNegadoQuandoAAutenticacaoFalhar() throws Exception {
		PayPalHttpService payPalHttpService = mock(PayPalHttpService.class);
		PagamentoService pagamentoService = new PagamentoService(payPalHttpService);
		
		Carrinho carrinho = new Carrinho(pagamentoService);
		
		when(payPalHttpService.authorize(anyString(), anyString())).thenReturn(false);
		
		assertThrows(IllegalArgumentException.class, () -> carrinho.fazPagamento());
	}	
	
}
