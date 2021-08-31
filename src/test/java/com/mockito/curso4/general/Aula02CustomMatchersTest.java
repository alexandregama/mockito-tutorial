package com.mockito.curso4.general;

import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatcher;

public class Aula02CustomMatchersTest {

	@SuppressWarnings("unchecked")
	@Test
	void deveriaValidarQueOsFrameworksSaoAdicionadosCorretamente() throws Exception {
		List<String> mock = mock(List.class);
		
		mock.addAll(List.of("Spring", "Hibernate", "Mockito"));
		
		verify(mock).addAll(List.of("Spring", "Hibernate", "Mockito"));
	}
	
	@SuppressWarnings("unchecked")
	@Test
	void deveriaValidarQueOsFrameworksSaoAdicionadosCorretamenteDeFormaElegante() throws Exception {
		List<String> mock = mock(List.class);
		
		mock.addAll(List.of("Spring", "Hibernate", "Mockito"));
		
		verify(mock).addAll(argThat(new FrameworksFamosos()));
	}
	
	@SuppressWarnings("unchecked")
	@Test
	void deveriaFalharQueOsFrameworksSaoAdicionadosCorretamenteDeFormaElegante() throws Exception {
		List<String> mock = mock(List.class);
		
		mock.addAll(List.of("Spring", "Infinispan", "Spark"));
		
		verify(mock).addAll(argThat(new FrameworksFamosos()));
	}
	
}

class FrameworksFamosos implements ArgumentMatcher<List<String>> {

	@Override
	public boolean matches(List<String> listaDeFrameworks) {
		return listaDeFrameworks.containsAll(List.of("Spring", "Hibernate", "Mockito"));
	}
	
	@Override
	public String toString() {
		return "[nao são frameworks famosos hein!]";
	}
	
}