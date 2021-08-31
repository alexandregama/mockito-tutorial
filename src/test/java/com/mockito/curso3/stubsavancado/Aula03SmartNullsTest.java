package com.mockito.curso3.stubsavancado;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.RETURNS_SMART_NULLS;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

public class Aula03SmartNullsTest {

	@Test
	void deveriaRetornarFalsePorPadrao() throws Exception {
		Pagamento pagamento = mock(Pagamento.class);
		
		boolean sucesso = pagamento.fazPagamento(); // vai retornar False por padrão pq não indiquei o que deveria acontecer
		
		assertTrue(sucesso);
	}
	
	@Test
	void deveriaRetornarFalsePorQueEuEnsinei() throws Exception {
		Pagamento pagamento = mock(Pagamento.class);
		
		when(pagamento.fazPagamento()).thenReturn(true);
		
		boolean sucesso = pagamento.fazPagamento();
		
		assertTrue(sucesso);
	}
	
	@Test
	void deveriaRetornarNullPointerException() throws Exception {
		Pagamento pagamento = mock(Pagamento.class);
		
		String username = pagamento.username();
		
		assertEquals("gama", username);
	}
	
	
	@Test
	void deveriaRetornarSmartNull() throws Exception {
		Pagamento pagamento = mock(Pagamento.class, RETURNS_SMART_NULLS);
		
		// neste caso retornará uma String vazia
		String username = pagamento.username();
		
		assertEquals("gama", username);
	}
	
}

class Pagamento {
	
	public String username() {
		return "gama";
	}
	
	public boolean fazPagamento() {
		return true;
	}
	
}
