package com.mockito.curso3.stubsavancado;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.RETURNS_SMART_NULLS;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

public class Aula04SmartNullRealCaseTest {

	@Test
	void deveriaFalharAoTentarEnviarUmEmail() throws Exception {
		EmailProvider provider = mock(EmailProvider.class);
		
		EmailService emailService = new EmailService(provider);
		
		String sucesso = emailService.send("Texto maroto do meu email");
		
		assertEquals("sucesso", sucesso);
	}
	
	@Test
	void deveriaEnviarUmEmailComSucesso() throws Exception {
		EmailProvider provider = mock(EmailProvider.class);
		
		when(provider.username()).thenReturn("");
		when(provider.password()).thenReturn("");
		when(provider.host()).thenReturn("");
		when(provider.port()).thenReturn("");
		
		EmailService emailService = new EmailService(provider);
		
		String sucesso = emailService.send("Texto maroto do meu email");
		
		assertEquals("sucesso", sucesso);
	}
	
	@Test
	void deveriaEnviarUmEmailComSucessoDeFormaMaisEsperta() throws Exception {
		EmailProvider provider = mock(EmailProvider.class, RETURNS_SMART_NULLS);
		
		EmailService emailService = new EmailService(provider);
		
		String sucesso = emailService.send("Texto maroto do meu email");
		
		assertEquals("sucesso", sucesso);
	}
	
	
}

class EmailService {
	
	private EmailProvider provider;
	
	public EmailService(EmailProvider provider) {
		this.provider = provider;
	}
	
	public String send(String text) {
		if (provider.username() == null) {
			throw new IllegalArgumentException("username nulo");
		}
		if (provider.password() == null) {
			throw new IllegalArgumentException("password nulo");
		}
		if (provider.host() == null) {
			throw new IllegalArgumentException("host nulo");
		}
		if (provider.port() == null) {
			throw new IllegalArgumentException("port nulo");
		}
		return "sucesso";
	}
	
	public String sendMaisEsperto(String text) {
		if (provider.username().isEmpty()) {
			throw new IllegalArgumentException("username vazio");
		}
		if (provider.password().isEmpty()) {
			throw new IllegalArgumentException("password vazio");
		}
		if (provider.host().isEmpty()) {
			throw new IllegalArgumentException("host vazio");
		}
		if (provider.port().isEmpty()) {
			throw new IllegalArgumentException("port vazio");
		}
		return "sucesso";
	}
	
}

class EmailProvider {
	
	public String username() {
		return "username vindo de algum canto - configuracao";
	}
	
	public String password() {
		return "password vindo de algum canto - configuracao";
	}
	
	public String host() {
		return "host vindo de algum canto - configuracao";
	}
	
	public String port() {
		return "port vindo de algum canto - configuracao";
	}
	
}