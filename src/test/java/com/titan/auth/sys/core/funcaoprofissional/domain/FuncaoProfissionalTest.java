package com.titan.auth.sys.core.funcaoprofissional.domain;

import com.titan.auth.sys.core.funcaoprofissional.domain.enums.Funcao;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Funcao Profissional - Dominio")
class FuncaoProfissionalTest {

	private final UUID profissionalId = UUID.randomUUID();
	private Funcao funcao = Funcao.PROFISSIONAL_SAUDE;

	@Test
	void testRegistrarFuncao() {
		var funcaoProfissional = FuncaoProfissional.registrarFuncao(
				this.profissionalId,
				this.funcao
		);

		assertAll("Verifica se todos os atributos da funcaos estão corretos",
				() -> assertEquals(this.profissionalId, funcaoProfissional.getProfissionalId()),
				() -> assertEquals(this.funcao, funcaoProfissional.getFuncao()));
	}
}