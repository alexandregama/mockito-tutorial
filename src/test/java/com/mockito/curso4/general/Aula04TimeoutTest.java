package com.mockito.curso4.general;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;

public class Aula04TimeoutTest {

	@Test
	void deveriaFalharPoisOGetNuncaFoiChamado21() throws Exception {
		HttpService httpService = mock(HttpService.class);
		
		verify(httpService, timeout(3_000)).get();
	}
	
	@Test
	void deveriaPassarPoisOMetodoExecutaEmMenosDe5Segundos() throws Exception {
		HttpService httpService = mock(HttpService.class);

		httpService.get();
		
		verify(httpService, timeout(3_000)).get();
	}
	
	@Test
	void naoDeveriaPassarPoisOMetodoEhExecutadoEmOutraThreadEDemoraMaisQue5Segundos() throws Exception {
		HttpService httpService = mock(HttpService.class);

		Thread thread = new Thread(() -> {
			try {
				Thread.sleep(8_000);
				httpService.get();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		thread.start();
		
		verify(httpService, timeout(3_000)).get();
	}
	
	@Test
	void deveriaPassarPoisOMetodoEhExecutadoEmOutraThreadEDemoraMenosQue3Segundos() throws Exception {
		HttpService httpService = mock(HttpService.class);
		
		Thread thread = new Thread(() -> {
			try {
				Thread.sleep(1_000);
				httpService.get();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		thread.start();
		System.out.println("id da outra thread: " + thread.getId());
		
		System.out.println("id da thread principal: " + Thread.currentThread().getId());
		verify(httpService, timeout(3_000)).get();
	}
	
}

class HttpService {
	
	public String get() {
		try {
			Thread.sleep(5_000);
			return "https://alexandregama.io";
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
