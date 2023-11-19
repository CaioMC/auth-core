package com.titan.auth.sys.core.auth;

import java.util.UUID;

public interface RefreshTokenUseCase {

	RegistrarUseCase.UsuarioCadastradoResult handle(RefreshTokenCommand command);

	record RefreshTokenCommand(String token) {}

	interface AuthProjection {

		UUID getId();
		String getCpf();
		String getEmail();
		String getPassword();

	}
}
