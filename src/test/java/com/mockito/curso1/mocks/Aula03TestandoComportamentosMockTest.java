package com.mockito.curso1.mocks;
			
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mockito.curso1.CursosDao;
import com.mockito.curso1.CursosService;

@ExtendWith(MockitoExtension.class)
public class Aula03TestandoComportamentosMockTest {
	
	@Mock
	private List linguagens;
	
	@Test
	@SuppressWarnings("unchecked")
	void deveriaValidarQueChamamosOMetodoDeAdicionar() throws Exception {
		linguagens.add("Java");

		verify(linguagens).add("Java");
	}
	
	@Test
	void deveriaValidarQueChamamosOMetodoDeAdicionarDuasVezes(@Mock List<String> linguagens) throws Exception {
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
