package com.mockito.curso2;

import java.util.List;

public class PayPalHttpService {

	public boolean authorize(String username, String password) {
		try {
			Thread.sleep(5_000);
			return username.equals("gama") && password.equals("12345");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean enviaPaginaPagamento(List<Produto> produtos) {
		try {
			Thread.sleep(2_000);
			if (produtos.size() > 0) {
				System.out.println("Pagamento com sucesso via HTTP");
				return true;
			}
			return false;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return false;
	}

}
