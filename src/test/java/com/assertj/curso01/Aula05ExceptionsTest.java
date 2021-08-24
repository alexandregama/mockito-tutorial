package com.assertj.curso01;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.catchThrowable;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

public class Aula05ExceptionsTest {

	@Test
	void deveriaLancarExceptionComMensagem() throws Exception {
		assertThatThrownBy(() -> new WebService().get(null)).hasMessage("Parametro invalido");
	}
	
	@Test
	void deveriaLancarExceptionComMensagemDeOutraForma() throws Exception {
		Throwable throwable = catchThrowable(() -> new WebService().get(null));
		
		assertThat(throwable).hasMessage("Parametro invalido");
	}
	
	@Test
	void deveriaLancarExceptionETestarPartesDaMensagem() throws Exception {
		Throwable throwable = catchThrowable(() -> new WebService().get(null));
		
		assertThat(throwable)
			.hasMessage("Parametro invalido")
			.hasMessageStartingWith("Parametro")
			.hasMessageContaining("invalido")
			.hasMessageContainingAll("metro", "inv")
			.hasMessageNotContaining("correto");
	}
	
	
	
	@Test
	void deveriaLancarIllegalArgumentExceptionQuandoParametroForNulo() throws Exception {
		assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> new WebService().get(null));
	}
	
	@Test
	void deveriaLancarExceptionETestarMensagemComRegex() throws Exception {
		Throwable throwable = catchThrowable(() -> new WebService().get(null));
		
		assertThat(throwable).hasMessageMatching("Parametro .*");
	}
	
	@Test
	void testName() throws Exception {
		Throwable throwable = catchThrowable(() -> new WebService().get(null));
		System.out.println(throwable.getCause());
		
		assertThat(throwable).hasCauseInstanceOf(IllegalArgumentException.class);
	}
	
	@Test
	public void shouldIndicateThatAClassIsAssignableFromAnotherClass() throws Exception {
		assertThat(Exception.class).isAssignableFrom(NoSuchElementException.class);
	}
	
}

class WebService {
	
	public String get(String url) {
		if (url == null)
			throw new IllegalArgumentException("Parametro invalido");
		else
			return "https://alexandregama.io/cursos";
	}
	
}
