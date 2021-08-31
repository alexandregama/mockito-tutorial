package com.mockito.curso2;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {
	
	private List<Produto> produtos = new ArrayList<>();
	private PagamentoService pagamento;
	
	public Carrinho(PagamentoService pagamento) {
		this.pagamento = pagamento;
	}

	public void adiciona(Produto produto) {
		produtos.add(produto);
	}
	
	public boolean fazPagamento() {
		boolean autorizado = pagamento.fazAutorizacao("gama", "12345");
		if (autorizado) {
			return pagamento.paga(produtos);
		} else {
			throw new IllegalArgumentException("Access denied");
		}
	}
	
}
