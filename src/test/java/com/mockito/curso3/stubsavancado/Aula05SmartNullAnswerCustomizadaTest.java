package com.mockito.curso3.stubsavancado;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.RETURNS_SMART_NULLS;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

public class Aula05SmartNullAnswerCustomizadaTest {

	@Test
	void deveriaEnviarUmEmailComSucessoQuandoMetodosJaRetornamDiferenteDeNulo() throws Exception {
		EmailProvider provider = mock(EmailProvider.class, RETURNS_SMART_NULLS);
		
		when(provider.username()).thenReturn("qualquer coisa");
		when(provider.password()).thenReturn("qualquer coisa");
		when(provider.host()).thenReturn("qualquer coisa");
		when(provider.port()).thenReturn("qualquer coisa");
		
		EmailService emailService = new EmailService(provider);
		
		String sucesso = emailService.sendMaisEsperto("Texto maroto do meu email");
		
		assertEquals("sucesso", sucesso);
	}
	
	/**
	 * ReturnsEmptyValues class 
	 */
	@Test
	void deveriaEnviarUmEmailComSucessoQuandoMetodosJaRetornamDiferenteDeNuloDeFormaEsperta() throws Exception {
		EmailProvider provider = mock(EmailProvider.class, new Answer<String>() {

			@Override
			public String answer(InvocationOnMock invocation) throws Throwable {
				Class<?> returnType = invocation.getMethod().getReturnType();
				if (returnType.isAssignableFrom(String.class)) {
					return "qualquer coisa";
				}
				return "";
			}
		});
		
		EmailService emailService = new EmailService(provider);
		
		String sucesso = emailService.sendMaisEsperto("Texto maroto do meu email");
		
		assertEquals("sucesso", sucesso);
	}
	
	
	@Test
	void deveriaEnviarUmEmailComSucessoQuandoMetodosJaRetornamDiferenteDeNuloDeFormaEspertaEBonita() throws Exception {
		EmailProvider provider = mock(EmailProvider.class, invocation -> {
			Class<?> returnType = invocation.getMethod().getReturnType();
			if (returnType.isAssignableFrom(String.class)) {
				return "qualquer coisa";
			}
			return "";
		});
		
		EmailService emailService = new EmailService(provider);
		
		String sucesso = emailService.sendMaisEsperto("Texto maroto do meu email");
		
		assertEquals("sucesso", sucesso);
	}
	
	@Test
	void deveriaEnviarUmEmailComSucessoQuandoMetodosJaRetornamDiferenteDeNuloDeFormaEspertaEMaisBonita() throws Exception {
		EmailProvider provider = mock(EmailProvider.class, answerCustomizado());
		
		EmailService emailService = new EmailService(provider);
		
		String sucesso = emailService.sendMaisEsperto("Texto maroto do meu email");
		
		assertEquals("sucesso", sucesso);
	}

	private Answer<String> answerCustomizado() {
		return invocation -> {
			Class<?> returnType = invocation.getMethod().getReturnType();
			if (returnType.isAssignableFrom(String.class)) {
				return "qualquer coisa";
			}
			return "";
		};
	}
	
}
