package com.mockito.curso3.stubsavancado;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.RETURNS_DEEP_STUBS;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

public class Aula06DeepStubTest {

	@Test
	void deveriaRetornarONomeDaCidadeComMock() throws Exception {
		Endereco endereco = mock(Endereco.class);
		Estado estado = mock(Estado.class);
		Cidade cidade = mock(Cidade.class);
		
		Pessoa pessoa = new Pessoa(endereco);
		
		when(endereco.getEstado()).thenReturn(estado);
		when(estado.getCidade()).thenReturn(cidade);

		assertNotNull(pessoa.getEndereco().getEstado().getCidade());;
	}
	
	@Test
	void deveriaRetornarONomeDaCidadeComMockDeFormaEsperta() throws Exception {
		Endereco endereco = mock(Endereco.class, RETURNS_DEEP_STUBS);
		
		Pessoa pessoa = new Pessoa(endereco);
		
		assertNotNull(pessoa.getEndereco().getEstado().getCidade());;
	}
	
}

class Pessoa {

	private Endereco endereco;

	public Pessoa(Endereco endereco) {
		this.endereco = endereco;
	}
	
	public Endereco getEndereco() {
		return endereco;
	}
	
}

class Endereco {
	
	private Estado estado;

	public Endereco(Estado estado) {
		this.estado = estado;
	}
	
	public Estado getEstado() {
		return estado;
	}
}

class Estado {
	
	private Cidade cidade;

	public Estado(Cidade cidade) {
		this.cidade = cidade;
	}
	
	public Cidade getCidade() {
		return cidade;
	}
}

class Cidade {
	
	private String nome;
	
	public String getNome() {
		return nome;
	}
	
}
