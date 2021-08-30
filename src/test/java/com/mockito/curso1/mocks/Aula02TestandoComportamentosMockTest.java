package com.mockito.curso1.mocks;
			
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.mockito.sistema.CursosDao;
import com.mockito.sistema.CursosService;

public class Aula02TestandoComportamentosMockTest {
	
	@Test
	@SuppressWarnings("unchecked")
	void deveriaValidarQueChamamosOMetodoDeAdicionar() throws Exception {
		List<String> linguagens = mock(List.class);
		
		linguagens.add("Java");

		verify(linguagens).add("Java");
	}
	
	@Test
	@SuppressWarnings("unchecked")
	void deveriaValidarQueChamamosOMetodoDeAdicionarDuasVezes() throws Exception {
		List<String> linguagens = mock(List.class);
		
		linguagens.add("Java");
		linguagens.add("Ruby");
		
		verify(linguagens, times(2)).add(anyString());
	}
	
	@Test
	void deveriaValidarQueAdicionamosUmaLinguagem() throws Exception {
		CursosDao dao = mock(CursosDao.class);
		CursosService cursosService = new CursosService(dao);
		
		cursosService.adiciona("Java");
		cursosService.lancaCursos();
		
		verify(dao).salva(anyList());
	}
	
}
