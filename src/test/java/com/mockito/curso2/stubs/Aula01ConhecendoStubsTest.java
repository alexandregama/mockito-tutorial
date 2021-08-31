package com.mockito.curso2.stubs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class Aula01ConhecendoStubsTest {

	@Test
	void deveriaAdicionarItensEmUmaListaConcreta() throws Exception {
		List<String> linguagens = new ArrayList<>();
		
		linguagens.add("Java");
		linguagens.add("Rust");
		linguagens.add("Flutter");
		linguagens.add("Go");
		
		assertEquals("Java", linguagens.get(0));
		assertEquals("Rust", linguagens.get(1));
		assertEquals("Flutter", linguagens.get(2));
		assertEquals("Go", linguagens.get(3));
	}
	
	@Test
	void deveriaAdicionarItensEmUmaGamaListConcreta() throws Exception {
		GamaList linguagens = new GamaList();
		
		linguagens.adiciona("Java");
		linguagens.adiciona("Rust");
		linguagens.adiciona("Flutter");
		linguagens.adiciona("Go");
		
		assertEquals("Java", linguagens.get(0));
		assertEquals("Rust", linguagens.get(1));
		assertEquals("Flutter", linguagens.get(2));
		assertEquals("Go", linguagens.get(3));
	}
	
	@Test
	void deveriaAdicionarItensEmUmaGamaListComMockitoEFalhar() throws Exception {
		GamaList linguagens = mock(GamaList.class);
		
		linguagens.adiciona("Java");
		linguagens.adiciona("Rust");
		linguagens.adiciona("Flutter");
		linguagens.adiciona("Go");
		
		assertEquals("Java", linguagens.get(0));
		assertEquals("Rust", linguagens.get(1));
		assertEquals("Flutter", linguagens.get(2));
		assertEquals("Go", linguagens.get(3));
	}
	
	@Test
	void deveriaAdicionarItensEmUmaGamaListComMockito() throws Exception {
		GamaList linguagens = mock(GamaList.class);
		
		when(linguagens.get(0)).thenReturn("Java");
		when(linguagens.get(1)).thenReturn("Rust");
		when(linguagens.get(2)).thenReturn("Flutter");
		when(linguagens.get(3)).thenReturn("Go");
		
		assertEquals("Java", linguagens.get(0));
		assertEquals("Rust", linguagens.get(1));
		assertEquals("Flutter", linguagens.get(2));
		assertEquals("Go", linguagens.get(3));
	}
	
}

