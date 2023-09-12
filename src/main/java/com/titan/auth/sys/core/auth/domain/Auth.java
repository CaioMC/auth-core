package com.titan.auth.sys.core.auth.domain;


import com.titan.auth.sys.core.infra.config.domain.entity.AbstractAuditableAggregate;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity(name = "auth")
public class Auth extends AbstractAuditableAggregate {

	@Id
	private UUID id;
	private UUID profissionalId;
	private String refreshToken;
	private String password;
	private UUID clinicaId;

	public static Auth registrarAuth(
			@NotNull UUID profissionalId,
			String refreshToken,
			@NotBlank String password,
			@NotBlank UUID clinicaId
	) {
		return new Auth(
				UUID.randomUUID(),
				profissionalId,
				refreshToken,
				password,
				clinicaId
		);
	}

	public Auth atualizarToken(@NotBlank String token) {
		this.refreshToken = token;
		return this;
	}

}
