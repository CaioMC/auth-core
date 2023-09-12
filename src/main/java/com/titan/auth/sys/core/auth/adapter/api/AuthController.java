package com.titan.auth.sys.core.auth.adapter.api;

import com.titan.auth.sys.core.auth.AutenticarUseCase;
import com.titan.auth.sys.core.auth.AutenticarUseCase.AutenticarCommand;
import com.titan.auth.sys.core.auth.RegistrarUseCase;
import com.titan.auth.sys.core.auth.RegistrarUseCase.RegistrarCommand;
import com.titan.auth.sys.core.auth.RegistrarUseCase.UsuarioCadastradoResult;
import com.titan.auth.sys.core.auth.adapter.api.dto.AutenticarDTO;
import com.titan.auth.sys.core.auth.adapter.api.dto.RegistrarDTO;
import com.titan.auth.sys.core.auth.adapter.api.dto.TokenDTO;
import com.titan.auth.sys.core.auth.adapter.api.openapi.AuthControllerOpenApi;
import com.titan.auth.sys.core.auth.exception.SenhaInvalidaException;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping(path = AuthController.PATH, produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
@Tag(name = "Auth Controller")
public class AuthController implements AuthControllerOpenApi {

	public static final String PATH = "api/auth";

	private final AutenticarUseCase autenticarUseCase;
	private final RegistrarUseCase registrarUseCase;

	@PostMapping("/sign-in")
	public ResponseEntity<TokenDTO> autenticarFuncionario(final @Valid @RequestBody AutenticarDTO dto) {
		try {
			AutenticarCommand command = new AutenticarCommand(dto.login(), dto.senha());

			UserDetails usuarioAutenticado = this.autenticarUseCase.handle(command);

			return ResponseEntity.ok(new TokenDTO(
					usuarioAutenticado.getUsername(), // Login
					usuarioAutenticado.getPassword()) // Token
			);
		} catch (UsernameNotFoundException | SenhaInvalidaException e) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, e.getMessage());
		}
	}

	@PostMapping("/sign-up")
	public ResponseEntity<UsuarioCadastradoResult> registrarFuncionario(final @Valid @RequestBody RegistrarDTO dto) {
		UsuarioCadastradoResult result = this.registrarUseCase.handle(RegistrarCommand.toCommand(dto));
		return ResponseEntity.ok(result);
	}

}
