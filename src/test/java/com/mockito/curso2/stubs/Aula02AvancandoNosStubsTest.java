package com.mockito.curso2.stubs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

public class Aula02AvancandoNosStubsTest {
	
	@Test
	void deveriaRetornarJavaComoLinguagem() throws Exception {
		GamaList linguagens = mock(GamaList.class);
		
		when(linguagens.get(0)).thenReturn("Java");
		
		assertEquals("Java", linguagens.get(0));
	}
	
	@Test
	void deveriaRetornarJavaParaQualquerIndice() throws Exception {
		GamaList linguagens = mock(GamaList.class);
		
		when(linguagens.get(anyInt())).thenReturn("Java");
		
		assertEquals("Java", linguagens.get(195));
	}
	
	@Test
	void deveriaLancarUmaExceptionReal() throws Exception {
		GamaList linguagens = new GamaList();
		
		assertThrows(IllegalArgumentException.class, () -> linguagens.adiciona("PHP"));
	}
	
	@Test
	void deveriaLancarUmaExceptionAoAdicionarPHPNaListaComMock() throws Exception {
		GamaList linguagens = mock(GamaList.class);
		
		doThrow(IllegalArgumentException.class).when(linguagens).adiciona("PHP");
		
		assertThrows(IllegalArgumentException.class, () -> linguagens.adiciona("PHP"));
	}
	
	@Test
	void deveriaLancarBuscarOItem12() throws Exception {
		GamaList linguagens = mock(GamaList.class);
		
		doThrow(IllegalArgumentException.class).when(linguagens).adiciona("PHP");
		
		assertThrows(IllegalArgumentException.class, () -> linguagens.adiciona("PHP"));
	}
	
	
	@Test
	void deveriaLancarUmaExceptionAoBuscarItem12() throws Exception {
		GamaList linguagens = new GamaList();
		
		assertThrows(IllegalArgumentException.class, () -> linguagens.get(12));
	}
	
	@Test
	void deveriaLancarUmaExceptionAoBuscarItem12ComMock() throws Exception {
		GamaList linguagens = mock(GamaList.class);

		when(linguagens.get(12)).thenThrow(IllegalArgumentException.class);
		
		assertThrows(IllegalArgumentException.class, () -> linguagens.get(12));
	}
	
}
