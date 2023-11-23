package com.titan.auth.sys.core.auth.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Auth - Dominio")
class AuthTest {

	private final UUID profissionalId = UUID.randomUUID();
	private final String refreshToken = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZDhjZDY2ZS0wM2RhLTQ2NzctOGM5Zi0xY2U2NmEzNzIwOGMiLCJleHAiOjE3MDA0MzE3OTZ9.0RVRUCBE65sTMChF3KhRuUJQZQ-md8MAvw0Nh9VibzZEJjYzuiV6bIktAnzwMI03l6bsYGa5zGUhqEjgDZjDgQ";
	private final String password = "$2a$10$yDxGUiB9U/T0dof6uUJPg.72fSzDQ3/vswwjw2.2MQF.xmvRAnYqm";
	private final UUID clinicaId = UUID.randomUUID();

	private final String newToken = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiI2Mjc1NzIxZi1kOTIzLTQ1ZTEtODY5Ny1jMzI2NTcxNDNkZjEiLCJleHAiOjE3MDA0MzQyMTZ9.syA9d0uWfeoBMJwkxm6muIjnnh0Y4yruhRmtBay8rXAKRLUdZid_P8FEg2ZdOYczD2M5p4GEv39rrNO2jLkGQQ";

	@Test
	void testRegistrarFuncionario() {
		var auth = Auth.registrarAuth(
				this.profissionalId,
				this.refreshToken,
				this.password,
				this.clinicaId
		);

		assertAll("Verifica se todos os atributos do auth estão corretos",
				() -> assertEquals(this.profissionalId, auth.getProfissionalId()),
				() -> assertEquals(this.refreshToken, auth.getRefreshToken()),
				() -> assertEquals(this.password, auth.getPassword()),
				() -> assertEquals(this.clinicaId, auth.getClinicaId())
		);
	}

	@Test
	void testAtualizarToken() {
		var auth = Auth.registrarAuth(
				this.profissionalId,
				this.refreshToken,
				this.password,
				this.clinicaId
		);

		auth.atualizarToken(this.newToken);

		assertEquals(this.newToken, auth.getRefreshToken());
	}
}
