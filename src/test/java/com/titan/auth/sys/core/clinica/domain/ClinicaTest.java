package com.titan.auth.sys.core.clinica.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Clinica - Dominio")
class ClinicaTest {

	private final String nome = "Marcos Augusto";
	private final String email = "marcos@gmail.com";


	@Test
	void testRegistrarClinicaPadrao() {
		var clinica = Clinica.registrarClinicaPadrao(
				this.nome,
				this.email
		);

		assertAll("Verifica se todos os atributos da clinica estão corretos",
				() -> assertEquals(this.nome + " Clinica", clinica.getNome()),
				() -> assertEquals(this.email, clinica.getEmail()));
	}
}