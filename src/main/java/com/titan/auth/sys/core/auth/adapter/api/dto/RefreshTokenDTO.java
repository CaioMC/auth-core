package com.titan.auth.sys.core.auth.adapter.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

public record RefreshTokenDTO(
		@Schema(description = "Informa o token do usuário.")
		@NotNull(message = "O token dever ser informado para ser atualizado")
		String token
) {
}
