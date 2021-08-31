package com.mockito.curso2.stubs;

import java.util.ArrayList;
import java.util.List;

public class GamaList {
	
	List<String> list = new ArrayList<>();
	
	public GamaList() {
		this.list = new ArrayList<String>();
	}
	
	public void adiciona(String item) {
		try {
			Thread.sleep(5_000);
			if (item.equals("PHP")) {
				throw new IllegalArgumentException("Linguagem nao permitida");
			}
			list.add(item);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public String get(int index) {
		if (index == 12) {
			throw new IllegalArgumentException("12 não vale");
		}
		return list.get(index);
	}
	
}