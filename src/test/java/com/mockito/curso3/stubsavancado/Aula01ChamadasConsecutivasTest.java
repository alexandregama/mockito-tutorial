package com.mockito.curso3.stubsavancado;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import com.mockito.curso2.stubs.GamaList;

public class Aula01ChamadasConsecutivasTest {

	@Test
	void deveriaFazerOStubVariasLinguagens() throws Exception {
		GamaList linguagens = mock(GamaList.class);
		
		when(linguagens.get(0)).thenReturn("Java");
		when(linguagens.get(1)).thenReturn("Ruby");
		when(linguagens.get(2)).thenReturn("Python");
		when(linguagens.get(3)).thenReturn("Go");
		when(linguagens.get(4)).thenReturn("Erlang");
		
		assertEquals("Java", linguagens.get(0));
		assertEquals("Ruby", linguagens.get(1));
		assertEquals("Python", linguagens.get(2));
		assertEquals("Go", linguagens.get(3));
		assertEquals("Erlang", linguagens.get(4));
	}
	
	@Test
	void deveriaFazerOStubDeLinguagensDeFormaConsecutiva() throws Exception {
		GamaList linguagens = mock(GamaList.class);
		
		when(linguagens.get(0))
			.thenReturn("Java")
			.thenReturn("Ruby")
			.thenReturn("Python")
			.thenReturn("Go")
			.thenReturn("Erlang");
		
		assertEquals("Java", linguagens.get(0));
		assertEquals("Ruby", linguagens.get(0));
		assertEquals("Python", linguagens.get(0));
		assertEquals("Go", linguagens.get(0));
		assertEquals("Erlang", linguagens.get(0));
	}
	
	@Test
	void deveriaFazerOStubDeLinguagensDeFormaConsecutivaComSintaxeMaisEnxuta() throws Exception {
		GamaList linguagens = mock(GamaList.class);
		
		when(linguagens.get(0)).thenReturn("Java", "Ruby", "Python", "Go", "Erlang");
		
		assertEquals("Java", linguagens.get(0));
		assertEquals("Ruby", linguagens.get(0));
		assertEquals("Python", linguagens.get(0));
		assertEquals("Go", linguagens.get(0));
		assertEquals("Erlang", linguagens.get(0));
	}
	
}
