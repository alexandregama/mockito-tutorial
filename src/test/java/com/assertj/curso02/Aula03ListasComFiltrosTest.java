package com.assertj.curso02;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class Aula03ListasComFiltrosTest {

	@Test
	void deveriaTestarListaComUmFiltroAntes() throws Exception {
		List<String> linguagens = asList("Java", "Ruby", "Python", "Haskell", "Go", "Erlang", "C", "Rust");

		assertThat(linguagens).filteredOn(linguagem -> linguagem.length() >= 5).containsOnly("Haskell", "Erlang", "Python");
	}
	
	@Test
	void deveriaTestarAListaEORankingDeCadaLinguagemQueSobrarDepoisDoFiltro() throws Exception {
		List<Linguagem> linguagens = asList(
			new Linguagem("Java", 1),
			new Linguagem("Ruby", 5),
			new Linguagem("Go", 3),
			new Linguagem("Erlang", 2),
			new Linguagem("Haskell", 9),
			new Linguagem("Rust", 7),
			new Linguagem("Python", 4)
		);
		
		assertThat(linguagens)
			.filteredOn(linguagem -> linguagem.getPosicao() < 5)
			.extracting(linguagem -> linguagem.getNome())
			.contains("Java", "Go", "Erlang");
	}
	
	@Test
	void DeveriaValidarSoORankingDe2020() throws Exception {
		List<Ano> anos = asList(
			new Ano(2019, new Ranking(new Linguagem("Java", 1), new Linguagem("Ruby", 2), new Linguagem("Rust", 3))),
			new Ano(2020, new Ranking(new Linguagem("Python", 1), new Linguagem("Java", 2), new Linguagem("C", 3))),
			new Ano(2021, new Ranking(new Linguagem("Rust", 1), new Linguagem("Java", 2), new Linguagem("Dart", 3)))
		);
		
		assertThat(anos)
			.extractingResultOf("getRanking")
			.hasSize(3);
	}
	
}

class Linguagem {
	
	private String nome;
	
	private int posicao;

	public Linguagem(String nome, int posicao) {
		super();
		this.nome = nome;
		this.posicao = posicao;
	}
	
	public String getNome() {
		return nome;
	}
	
	public int getPosicao() {
		return posicao;
	}
	
}

class Ranking {
	
	private List<Linguagem> lista = new ArrayList<>();
	
	public Ranking(Linguagem...linguagens) {
	}
	
	public List<Linguagem> getLista() {
		return lista;
	}
}

class Ano {
	
	private int ano;
	private Ranking ranking;
	
	public Ano(int ano, Ranking ranking) {
		this.ano = ano;
		this.ranking = ranking;
	}
	
	public int getAno() {
		return ano;
	}
	
	public Ranking getRanking() {
		return ranking;
	}
	
}