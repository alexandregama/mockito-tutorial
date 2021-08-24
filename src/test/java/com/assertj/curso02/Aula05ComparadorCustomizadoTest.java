package com.assertj.curso02;

import static org.assertj.core.api.Assertions.*;

import java.util.Comparator;

import org.junit.jupiter.api.Test;

public class Aula05ComparadorCustomizadoTest {

	@Test
	void deveriaValidarQueOsDoisDocumentosSaoDocumentosPessoais() throws Exception {
		Documento cpf = new Cpf();
		Documento rg = new Rg();
		
		assertThat(cpf).usingComparator(new DocumentoPessoalComparator()).isEqualTo(rg);
	}
	
	@Test
	void deveriaIndicarQueOsDoisNaoSaoDocumentosPessoais() throws Exception {
		Documento cpf = new Cpf();
		Documento cnpj = new CNPJ();
		
		assertThat(cpf).usingComparator(new DocumentoPessoalComparator()).isEqualTo(cnpj);
	}
	
	@Test
	void deveriaIndicarQueOsDoisDocumentos() throws Exception {
		Documento cpf = new Cpf();
		Documento cnpj = new CNPJ();
		
		assertThat(cpf).usingComparator(new DocumentoComparator()).isEqualTo(cnpj);
	}
	
}

class DocumentoPessoalComparator implements Comparator<Documento> {

	@Override
	public int compare(Documento o1, Documento o2) {
		return (o1 instanceof DocumentoPessoal && o2 instanceof DocumentoPessoal) ? 0 : 1;
	}
	
}

class DocumentoComparator implements Comparator<Documento> {

	@Override
	public int compare(Documento o1, Documento o2) {
		return (o1 instanceof Documento) && (o2 instanceof Documento) ? 0 : 1;
	}
	
}


interface Documento {
	
	void exibeNumero();
	
}

abstract class DocumentoPessoal {
	
}

abstract class DocumentoEmpresarial {
	
}

class Cpf extends DocumentoPessoal implements Documento {

	@Override
	public void exibeNumero() {
		System.out.println("Número CPF");
	}
	
}

class Rg extends DocumentoPessoal implements Documento {

	@Override
	public void exibeNumero() {
		System.out.println("Número RG");
	}
	
}

class CNPJ extends DocumentoEmpresarial implements Documento {

	@Override
	public void exibeNumero() {
		System.out.println("Número CNPJ");
	}
	
	
	
}

