package com.mockito.curso3.stubsavancado;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import com.mockito.curso2.stubs.GamaList;

public class Aula02StubbingCallbacksTest {
	
	@Test
	void deveriaRetornarJavaParaOPrimeiroElemento() throws Exception {
		GamaList lista = mock(GamaList.class);
		
		when(lista.get(0)).thenReturn("Java");
		
		assertEquals("Java", lista.get(0));
	}

	@Test
	void deveriaRetornarJavaParaOPrimeiroElementoDeFormaMaisDramaticaEDificil() throws Exception {
		GamaList lista = mock(GamaList.class);
		
		when(lista.get(0)).thenAnswer(new Answer<String>() {

			@Override
			public String answer(InvocationOnMock invocation) throws Throwable {
				return "Java";
			}
		});
		
		assertEquals("Java", lista.get(0));
	}
	
	@Test
	void deveriaTerAcessoAsInformacoesDoStub() throws Exception {
		GamaList lista = mock(GamaList.class);
		
		when(lista.get(0)).thenAnswer(new Answer<String>() {
			
			@Override
			public String answer(InvocationOnMock invocation) throws Throwable {
				Object[] arguments = invocation.getArguments();
				String argumentos = Arrays.toString(arguments);
				System.out.println(argumentos);
				
				System.out.println(invocation.getMethod());
				return "Java";
			}
		});
		
		assertEquals("Java", lista.get(0));
	}
	
	@Test
	void deveriaTerAcessoAsInformacoesDoStubUsandoJava8() throws Exception {
		GamaList lista = mock(GamaList.class);
		
		when(lista.get(0)).thenAnswer(invocation -> {
			Object[] arguments = invocation.getArguments();
			String argumentos = Arrays.toString(arguments);
			System.out.println(argumentos);
			
			System.out.println(invocation.getMethod());
			return "Java";
		});
		
		assertEquals("Java", lista.get(0));
	}
	
}
