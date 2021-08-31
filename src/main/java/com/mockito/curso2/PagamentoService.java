package com.mockito.curso2;

import java.util.List;

public class PagamentoService {

	private PayPalHttpService payPalHttpService;
	
	public PagamentoService(PayPalHttpService service) {
		payPalHttpService = service;
	}
	
	public boolean fazAutorizacao(String username, String password) {
		return payPalHttpService.authorize(username, password);
	}

	public boolean paga(List<Produto> produtos) {
		return payPalHttpService.enviaPaginaPagamento(produtos);
	}

}
