package com.mockito.curso1.mocks;

import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.atMostOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import com.mockito.curso1.CursosDao;
import com.mockito.curso1.CursosService;

public class Aula04MockitoInteractionsTest {
	
	@Mock
	private CursosDao dao;

	@Test
	void deveriaRetornarUmaLinguagemPeloNome() throws Exception {
		CursosService cursosService = new CursosService(dao);
		
		cursosService.adiciona("Java");
		cursosService.adiciona("Haskell");
		cursosService.adiciona("Rust");
		
		cursosService.buscaPeloNome("Haskell");
		
		verify(dao).findByName("Haskell");
	}
	
	@Test
	void deveriaRetornarUmaLinguagemQualquerPeloNome() throws Exception {
		CursosDao dao = mock(CursosDao.class);
		CursosService cursosService = new CursosService(dao);
		
		cursosService.adiciona("Java");
		cursosService.adiciona("Haskell");
		cursosService.adiciona("Rust");
		
		cursosService.buscaPeloNome("Haskell");
		
		verify(dao).findByName(anyString());
	}
	
	@Test
	void deveriaRetornarUmaLinguagemQualquerPeloNomeChamandoOMetodoDuasVezes() throws Exception {
		CursosDao dao = mock(CursosDao.class);
		CursosService cursosService = new CursosService(dao);
		
		cursosService.adiciona("Java");
		cursosService.adiciona("Haskell");
		cursosService.adiciona("Rust");
		
		cursosService.buscaPeloNome("Haskell");
		
		verify(dao, times(2)).findByName(anyString());
	}
	
	@Test
	void deveriaRetornarUmaLinguagemQualquerPeloNomePeloMenosUmaVez() throws Exception {
		CursosDao dao = mock(CursosDao.class);
		CursosService cursosService = new CursosService(dao);
		
		cursosService.adiciona("Java");
		cursosService.adiciona("Haskell");
		cursosService.adiciona("Rust");
		
		cursosService.buscaPeloNome("Haskell");
		
		verify(dao, atLeastOnce()).findByName(anyString());
	}
	
	@Test
	void deveriaRetornarUmaLinguagemQualquerPeloNomePeloMenos2Vezes() throws Exception {
		CursosDao dao = mock(CursosDao.class);
		CursosService cursosService = new CursosService(dao);
		
		cursosService.adiciona("Java");
		cursosService.adiciona("Haskell");
		cursosService.adiciona("Rust");
		
		cursosService.buscaPeloNome("Haskell");
		
		verify(dao, atLeast(2)).findByName(anyString());
	}
	
	@Test
	void deveriaRetornarUmaLinguagemQualquerNoMaximo1Vez() throws Exception {
		CursosDao dao = mock(CursosDao.class);
		CursosService cursosService = new CursosService(dao);
		
		cursosService.adiciona("Java");
		cursosService.adiciona("Haskell");
		cursosService.adiciona("Rust");
		
		verify(dao, atMostOnce()).salva(anyList());
	}
	
	@Test
	void deveriaRetornarUmaLinguagemQualquerNoMaximo2Vezes() throws Exception {
		CursosDao dao = mock(CursosDao.class);
		CursosService cursosService = new CursosService(dao);
		
		cursosService.adiciona("Java");
		cursosService.adiciona("Haskell");
		cursosService.adiciona("Rust");
		
		cursosService.buscaPeloNome("Haskell");
		
		verify(dao, atMost(1)).findByName(anyString());
	}
	
	@Test
	void naoDeveriaChamarOMetodoSalvar() throws Exception {
		CursosDao dao = mock(CursosDao.class);
		CursosService cursosService = new CursosService(dao);
		
		cursosService.buscaPeloNome("Haskell");
		
		verify(dao, never()).salva(anyList());
	}
	
	@Test
	void naoDeveriaTerMaisInteracoesComOCursosDao() throws Exception {
		CursosDao dao = mock(CursosDao.class);
		CursosService cursosService = new CursosService(dao);
		
		cursosService.adiciona("Haskell");
		cursosService.lancaCursos();
		
		verify(dao).salva(anyList());
		
		verifyNoMoreInteractions(dao);
		
	}
	
	@Test
	void naoDeveriaTerMaisInteracoesComOCursosDaoDeOutraForma() throws Exception {
		CursosDao dao = mock(CursosDao.class);
		CursosService cursosService = new CursosService(dao);
		
		cursosService.adiciona("Haskell");
		cursosService.lancaCursos();
		
		verify(dao, only()).salva(anyList());
	}
	
	@Test
	void naoDeveriaTerNenhumaInteracaoComOCursosDao() throws Exception {
		CursosDao dao = mock(CursosDao.class);
		CursosService cursosService = new CursosService(dao);
		
		cursosService.imprime();
		
		verifyNoInteractions(dao);
	}
	
	
}
