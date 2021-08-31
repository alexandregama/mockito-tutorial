package com.mockito.curso1;

import java.util.ArrayList;
import java.util.List;

public class CursosDao {

	private List<String> linguagens = new ArrayList<>();

	public void salva(List<String> linguagens) {
		try {
			Thread.sleep(5_000);
			linguagens.forEach(linguagem -> this.linguagens.add(linguagem));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public List<String> getListaDeLinguagens() {
		return this.linguagens;
	}

	public String findByName(String nome) {
		return linguagens.stream().filter(linguagem -> linguagem.equals(nome)).findFirst().get();
	}
	 
}
