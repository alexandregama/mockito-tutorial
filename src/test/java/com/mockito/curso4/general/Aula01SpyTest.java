package com.mockito.curso4.general;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.mockito.curso2.stubs.GamaList;

public class Aula01SpyTest {
	
	@Test
	void deveriaTestarAListaReal() throws Exception {
		GamaList lista = new GamaList();
		
		lista.adiciona("Java");
		lista.adiciona("Ruby");
		
		assertEquals("Java", lista.get(0));
	}

	@Test
	void deveriaCriarUmMockParaGamaList() throws Exception {
		GamaList lista = mock(GamaList.class);
		
		lista.adiciona("Java"); // não tem efeito prático
		
		when(lista.get(0)).thenReturn("Java");
		when(lista.get(1)).thenReturn("Ruby");
		
		assertEquals("Java", lista.get(0));
	}
	
	/**
	 * A spy is a partial mock, that calls the real methods unless the method is explicitly stubbed. 
	 */
	@Test
	void deveriaTestarCriandoUmMockParcial() throws Exception {
		GamaList lista = spy(new GamaList());
		
		lista.adiciona("Java"); // get(0)
		
//		when(lista.get(1)).thenReturn("Ruby"); não vai rolar pois estamos chamando o método real
		doReturn("Ruby").when(lista).get(1);
		
		assertEquals("Java", lista.get(0));
		assertEquals("Ruby", lista.get(1));
	}
	
	@Test
	@SuppressWarnings("unchecked")
	void deveriaTestarCriandoUmMockParcialDeOutraForma() throws Exception {
		List<String> lista = mock(LinkedList.class);
		
		doCallRealMethod().when(lista).add("Java");
		lista.add("Java");
		
		when(lista.get(1)).thenReturn("Ruby");
		
		assertEquals("Java", lista.get(0));
		assertEquals("Ruby", lista.get(1));
	}
	
}
