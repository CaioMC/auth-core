package com.titan.auth.sys.core.telefoneclinica.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Telefone Clinica - Dominio")
class TelefoneClinicaTest {

	private final UUID clinicaId = UUID.randomUUID();
	private final String telefone = "47998534376";

	@Test
	void testRegistrarTelefoneClinica() {
		var telefoneClinica = TelefoneClinica.registrarTelefoneClinica(
				this.clinicaId,
				this.telefone
		);

		assertAll("Verifica se todos os atributos da funcaos estão corretos",
				() -> assertEquals(this.clinicaId, telefoneClinica.getClinicaId()),
				() -> assertEquals(this.telefone, telefoneClinica.getTelefone()));
	}
}