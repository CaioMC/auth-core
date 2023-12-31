package com.titan.auth.sys.core.auth.adapter.api.openapi;

import com.titan.auth.sys.core.auth.RegistrarUseCase.UsuarioCadastradoResult;
import com.titan.auth.sys.core.auth.adapter.api.dto.AutenticarDTO;
import com.titan.auth.sys.core.auth.adapter.api.dto.RefreshTokenDTO;
import com.titan.auth.sys.core.auth.adapter.api.dto.RegistrarDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface AuthControllerOpenApi {

	@Operation(description = "API responsável por autenticar o usuário do sistema.", method = "POST")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Autenticação realizada com sucesso."),
			@ApiResponse(responseCode = "400", description = "Solicitação de autenticação inválida, não foi possível autenticar usuário.")
	})
	ResponseEntity<UsuarioCadastradoResult> autenticarFuncionario(final @RequestBody AutenticarDTO dto);


	@Operation(description = "API responsável por cadastrar o usuário do sistema.", method = "POST")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Autenticação realizada com sucesso."),
			@ApiResponse(responseCode = "400", description = "Solicitação de cadastro inválida, não foi possível cadastrar usuário.")
	})
	ResponseEntity<UsuarioCadastradoResult> registrarFuncionario(final @RequestBody RegistrarDTO dto);

	@Operation(description = "API responsável por atualizar o token do sistema.", method = "POST")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Atualização do token realizada com sucesso."),
			@ApiResponse(responseCode = "400", description = "Solicitação de atualização do token não foi realizada com sucesso.")
	})
	ResponseEntity<UsuarioCadastradoResult> atualizarToken(final RefreshTokenDTO dto);

}
