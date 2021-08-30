package com.mockito.curso1.mocks;

import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

import com.mockito.sistema.CursosDao;
import com.mockito.sistema.CursosService;

public class Aula04OrderingTest {

	@Test
	void deveriaValidarQueSalvouEBuscouUmaLinguagem() throws Exception {
		CursosDao dao = mock(CursosDao.class);
		CursosService cursosService = new CursosService(dao);
		
		cursosService.adiciona("Java");
		cursosService.lancaCursos();

		cursosService.buscaPeloNome("Java");
		
		verify(dao).salva(anyList());
		verify(dao).findByName(anyString());
	}
	
	@Test
	void deveriaFalharPoisAOrdemEstaErrada() throws Exception {
		CursosDao dao = mock(CursosDao.class);
		CursosService cursosService = new CursosService(dao);
		
		cursosService.buscaPeloNome("Java");
		
		cursosService.adiciona("Java");
		cursosService.lancaCursos();
		
		InOrder inOrder = Mockito.inOrder(dao);
		
		inOrder.verify(dao).salva(anyList());
		inOrder.verify(dao).findByName(anyString());
	}
	
	@Test
	void deveriaSalvarEBuscarNestaExataOrdem() throws Exception {
		CursosDao dao = mock(CursosDao.class);
		CursosService cursosService = new CursosService(dao);
		
		cursosService.adiciona("Java");
		cursosService.lancaCursos();
		
		cursosService.buscaPeloNome("Java");
		
		InOrder inOrder = Mockito.inOrder(dao);
		
		inOrder.verify(dao).salva(anyList());
		inOrder.verify(dao).findByName(anyString());
		inOrder.verify(dao).findByName(anyString());
	}
	
	@Test
	void deveriaSalvarEmInstanciasDeDaosDiferentes() throws Exception {
		CursosDao postgresDao = mock(CursosDao.class);
		CursosService cursosServicePostgres = new CursosService(postgresDao);
		
		CursosDao mysqlDao = mock(CursosDao.class);
		CursosService cursosServiceMysql = new CursosService(mysqlDao);
		
		cursosServicePostgres.adiciona("Java");
		cursosServicePostgres.lancaCursos();
		
		cursosServiceMysql.adiciona("Java");
		cursosServiceMysql.lancaCursos();
		
		InOrder inOrder = inOrder(mysqlDao, postgresDao);
		
		inOrder.verify(postgresDao).salva(anyList());
		inOrder.verify(mysqlDao).salva(anyList());
	}
	
}








