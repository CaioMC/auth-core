package com.titan.auth.sys.core.auth.adapter.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import jakarta.validation.constraints.NotBlank;

public record AutenticarDTO(
		@Schema(description = "Informa o login da preferência do usuário, sendo CPF ou EMAIL.")
		@NotBlank(message = "O login deve ser informado para a autenticação do sistema.")
		String login,
		@Schema(description = "Informa a senha registrada pelo usuário no sistema.")
		@NotBlank(message = "A senha deve ser informada para a autenticação do sistema.")
		String senha
) {
}
