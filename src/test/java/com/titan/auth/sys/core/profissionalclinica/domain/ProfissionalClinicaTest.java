package com.titan.auth.sys.core.profissionalclinica.domain;

import com.titan.auth.sys.core.funcaoprofissional.domain.FuncaoProfissional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Profissional Clinica - Dominio")
class ProfissionalClinicaTest {

	private final UUID clinicaId = UUID.randomUUID();
	private final UUID profissionalId = UUID.randomUUID();


	@Test
	void testRegistrarProfissionalClinica() {
		var clinica = ProfissionalClinica.registrarProfissionalClinica(
				this.clinicaId,
				this.profissionalId
		);

		assertAll("Verifica se todos os atributos da clinica estão corretos",
				() -> assertEquals(this.profissionalId, clinica.getProfissionalId()),
				() -> assertEquals(this.clinicaId, clinica.getClinicaId()));
	}
}