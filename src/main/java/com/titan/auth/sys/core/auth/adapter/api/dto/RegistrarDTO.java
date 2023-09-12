package com.titan.auth.sys.core.auth.adapter.api.dto;

import com.titan.auth.sys.core.profissional.domain.enums.ConcelhoProfissional;
import com.titan.auth.sys.core.profissional.domain.enums.ProfissaoEspecializada;
import com.titan.auth.sys.core.profissional.domain.enums.Sexo;
import com.titan.auth.sys.core.profissional.domain.enums.TratamentoProfissional;
import com.titan.auth.sys.core.profissional.domain.enums.Uf;
import io.swagger.v3.oas.annotations.media.Schema;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RegistrarDTO(
		@Schema(description = "Informa o nome completo do usuário.")
		@NotBlank(message = "O nome dever ser informado para o cadastro do usuário")
		String nome,
		@Schema(description = "Informa o email do usuário.")
		@NotBlank(message = "O email dever ser informado para o cadastro do usuário")
		String email,
		@Schema(description = "Informa o cpf do usuário.")
		@NotBlank(message = "O cpf dever ser informado para o cadastro do usuário")
		String cpf,
		@Schema(description = "Informa o celular do usuário.")
		@NotBlank(message = "O celular dever ser informado para o cadastro do usuário")
		String celular,
		@Schema(description = "Informa o sexo do usuário.")
		@NotNull(message = "O sexo dever ser informado para o cadastro do usuário")
		Sexo sexo,
		@Schema(description = "Informa o tratamento profissional do usuário.")
		@NotNull(message = "O tratamento profissional dever ser informado para o cadastro do usuário")
		TratamentoProfissional tratamento,
		@Schema(description = "Informa o concelho profissional do usuário.")
		@NotNull(message = "O concelho profissional dever ser informado para o cadastro do usuário")
		ConcelhoProfissional concelhoProfissional,
		@Schema(description = "Informa o registro profissional do usuário.")
		@NotBlank(message = "O registro profissional dever ser informado para o cadastro do usuário")
		String registro,
		@Schema(description = "Informa o tratamento profissional do usuário.")
		@NotNull(message = "A unidade federativa dever ser informado para o cadastro do usuário")
		Uf uf,
		@Schema(description = "Informa a profissão do usuário.")
		@NotNull(message = "A profissão dever ser informado para o cadastro do usuário")
		ProfissaoEspecializada profissao,
		@Schema(description = "Informa o CBO do usuário.")
		@NotNull(message = "A profissão dever ser informado para o cadastro do usuário")
		String cbo,
		@Schema(description = "Informa o CBO do usuário.")
		@NotNull(message = "O CBO dever ser informado para o cadastro do usuário")
		String rqe,
		@Schema(description = "Informa o CNES do usuário.")
		@NotNull(message = "O CNES dever ser informado para o cadastro do usuário")
		String cnes,
		@Schema(description = "Informa o senha recebida pelo usuário.")
		@NotNull(message = "A senha dever ser informada para o cadastro do usuário")
		String senha
) {
}
