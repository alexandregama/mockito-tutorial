package com.mockito.curso1.mocks;
			
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.mockito.curso1.CursosDao;
import com.mockito.curso1.CursosService;

public class Aula01TestandoComportamentosTest {
	
	@Test
	void deveriaValidarQueChamamosOMetodoDeAdicionar() throws Exception {
		List<String> linguagens = new ArrayList<>();
		
		linguagens.add("Java");
		
		assertEquals("Java", linguagens.get(0));
	}
	
	@Test
	void deveriaValidarQueChamamosOMetodoDeAdicionarDuasVezes() throws Exception {
		List<String> linguagens = new ArrayList<>();
		
		linguagens.add("Java");
		linguagens.add("Ruby");
		
		assertEquals("Java", linguagens.get(0));
		assertEquals("Ruby", linguagens.get(1));
	}
	
	@Test
	void deveriaValidarQueAdicionamosUmaLinguagem() throws Exception {
		CursosService cursosService = new CursosService(new CursosDao());
		
		cursosService.adiciona("Java");
		
		assertEquals("Java", cursosService.lista().get(0));
	}
	
	@Test
	void deveriaChamarOMetodoSalvaDoDao() throws Exception {
		CursosDao dao = new CursosDao();
		CursosService cursosService = new CursosService(dao);
		
		cursosService.adiciona("Java");
		cursosService.adiciona("Python");
		
		cursosService.lancaCursos();
		
		List<String> linguagens = dao.getListaDeLinguagens();
		
		assertEquals("Java", linguagens.get(0));
		assertEquals("Python", linguagens.get(1));
	}
	
}
