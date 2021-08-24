package com.assertj.curso03;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.assertj.core.presentation.StandardRepresentation;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class Aula04RepresentacaoCustomizadaTest {

	@BeforeAll
	public static void beforeAll( ) {
		Assertions.useRepresentation(new CustomRepresentation());
	}
	
	@Test
	void deveriaTerODocumentoPreenchido() throws Exception {
		Documento documento = new ServicoFinanceiro().enviaDocumentos(null);
		
		assertThat(documento).withRepresentation(new CustomRepresentation()).isNull();
	}
	
	@Test
	void deveriaTerONomeCorreto() throws Exception {
		String nome = "Alexandre Gam";
		
		assertThat(nome).isEqualTo("Alexandre Gama");
	}
	
}

class ServicoFinanceiro {
	
	public Documento enviaDocumentos(String cpf) {
		if (cpf != null) {
			return new Documento(cpf);
		} else {
			return null;
		}
	}
	
}

class Documento {
	
	String codigo;
	
	public Documento(String codigo) {
		this.codigo = codigo;
	}
	
	public String getCodigo() {
		return codigo;
	}
}


class CustomRepresentation extends StandardRepresentation {
	
	
	@Override
	protected String fallbackToStringOf(Object object) {
		if (object instanceof Documento) {
			return "WebService - Serviço Financeiro para Documentos";
		}
		return super.fallbackToStringOf(object);
	}
	
	@Override
	protected String toStringOf(String mensagem) {
		return ">>> ".concat(mensagem).concat(" <<<");
	}
	
}