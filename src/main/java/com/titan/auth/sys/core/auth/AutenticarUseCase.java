package com.titan.auth.sys.core.auth;

import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.UUID;

public interface AutenticarUseCase extends UserDetailsService {

	RegistrarUseCase.UsuarioCadastradoResult handle(AutenticarCommand command);

	record AutenticarCommand(String login, String senha) {
	}

	interface AuthProjection {

		UUID getId();
		String getCpf();
		String getEmail();
		String getPassword();

	}
}
