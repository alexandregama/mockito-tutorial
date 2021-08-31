package com.mockito.curso4.general;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

/**
 * https://medium.com/trabe/mocking-with-mockito-advanced-techniques-3a4e5143c2ba
 */
public class Aula03CaptorTest {

	@Test
	void deveriaRetornarOsTopFrameworks() throws Exception {
		FrameworksService frameworksService = mock(FrameworksService.class);
		
		CursosService service = new CursosService(frameworksService);
		
		List<String> lista = asList("Java", "Ruby", "Python");
		
		service.topFrameworks();
		
		verify(frameworksService).topFrameworks(lista);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	void deveriaRetornarOsTopFrameworksCapturandoOsArgumentos() throws Exception {
		FrameworksService frameworksService = mock(FrameworksService.class);
		
		CursosService service = new CursosService(frameworksService);
		
		ArgumentCaptor<List<String>> listaLinguagens = ArgumentCaptor.forClass(List.class);
		
		service.topFrameworks();
		
		verify(frameworksService).topFrameworks(listaLinguagens.capture());
		
		assertThat(listaLinguagens.getValue()).contains("Java", "Ruby", "Python");
	}
	
}

class CursosService {
	
	private FrameworksService frameworksService;

	public CursosService(FrameworksService frameworksService) {
		this.frameworksService = frameworksService;
	}
	
	public List<String> topFrameworks() {
		List<String> linguagens = new LinguagensService().topLinguagens();
		
		List<String> frameworks = frameworksService.topFrameworks(linguagens);
		
		return frameworks;
	}
	
}

class LinguagensService {

	public List<String> topLinguagens() {
		return Arrays.asList("Java", "Ruby", "Python");
	}
	
	public List<String> top3LinguagensDoMes() {
		return Arrays.asList("Python", "Java", "Python");
	}
	
}

class FrameworksService {

	public List<String> topFrameworks(List<String> linguagens) {
		List<String> frameworks = new ArrayList<>();
		if (linguagens.contains("Java")) {
			frameworks.add("Spring");
			frameworks.add("Spark");
		}
		if (linguagens.contains("Ruby")) {
			frameworks.add("Rails");
		}
		if (linguagens.contains("Python")) {
			frameworks.add("Django");
		}
		return frameworks;
	}
	
}