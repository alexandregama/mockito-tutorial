package com.mockito.curso1;

import java.util.ArrayList;

import java.util.List;

public class CursosService {

	List<String> linguagens = new ArrayList<>();
	
	private CursosDao dao;
	
	public CursosService(CursosDao dao) {
		this.dao = dao;
	}
	
	public void adiciona(String linguagem) {
		linguagens.add(linguagem);
	}
	
	public void lancaCursos() {
		dao.salva(linguagens);
	}
	
	public List<String> lista() {
		return linguagens;
	}
	
	public String buscaPeloNome(String nome) {
		return dao.findByName(nome);
	}
	
	public void imprime() {
		System.out.println(this.linguagens);
	}
	
}
