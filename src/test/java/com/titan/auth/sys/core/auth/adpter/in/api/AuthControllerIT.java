package com.titan.auth.sys.core.auth.adpter.in.api;

import com.titan.auth.sys.core.auth.AutenticarUseCase;
import com.titan.auth.sys.core.auth.RefreshTokenUseCase;
import com.titan.auth.sys.core.auth.RegistrarUseCase;
import com.titan.auth.sys.core.auth.adapter.api.AuthController;
import com.titan.auth.sys.core.auth.adapter.api.dto.AutenticarDTO;
import com.titan.auth.sys.core.auth.adapter.api.dto.RefreshTokenDTO;
import com.titan.auth.sys.core.auth.adapter.api.dto.RegistrarDTO;
import com.titan.auth.sys.core.auth.domain.AuthDomainRepository;
import com.titan.auth.sys.core.profissional.domain.enums.ConcelhoProfissional;
import com.titan.auth.sys.core.profissional.domain.enums.ProfissaoEspecializada;
import com.titan.auth.sys.core.profissional.domain.enums.Sexo;
import com.titan.auth.sys.core.profissional.domain.enums.TratamentoProfissional;
import com.titan.auth.sys.core.profissional.domain.enums.Uf;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc(addFilters = false)
@Transactional
@Rollback
@DisplayName("Auth Controller - API")
class AuthControllerIT {

	@InjectMocks
	private AuthController authController;

	@Mock
	private AuthDomainRepository repository;


	@Mock
	private RegistrarUseCase registrarUseCase;

	@Mock
	private AutenticarUseCase autenticarUseCase;

	@Mock
	private RefreshTokenUseCase refreshTokenUseCase;

	@Test
	void testRegistrarFuncionarioSuccess() {
		RegistrarDTO registrarDTO = new RegistrarDTO(
				"Caio",
				"caio.coelho@gmail.com",
				"03119654332",
				"47996213537",
				Sexo.MASCULINO,
				TratamentoProfissional.DR,
				ConcelhoProfissional.CBOO,
				"123",
				Uf.ACRE,
				ProfissaoEspecializada.ASSISTENTE_SOCIAL,
				"123",
				"123",
				"123",
				"123"
		);

		ResponseEntity<RegistrarUseCase.UsuarioCadastradoResult> response = authController.registrarFuncionario(registrarDTO);
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}

	@Test
	void testAutenticarFuncionarioSuccess() {

		AutenticarDTO autenticarDTO = new AutenticarDTO(
		"caio","123"
		);

		ResponseEntity<RegistrarUseCase.UsuarioCadastradoResult> response = authController.autenticarFuncionario(autenticarDTO);
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}

	@Test
	void testRefreshTokenSuccess() {
		RefreshTokenDTO refreshTokenDTO = new RefreshTokenDTO(
				"eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZDhjZDY2ZS0wM2RhLTQ2NzctOGM5Zi0xY2U2NmEzNzIwOGMiLCJleHAiOjE3MDA0MzE3OTZ9.0RVRUCBE65sTMChF3KhRuUJQZQ-md8MAvw0Nh9VibzZEJjYzuiV6bIktAnzwMI03l6bsYGa5zGUhqEjgDZjDgQ"
		);

		ResponseEntity<RegistrarUseCase.UsuarioCadastradoResult> response = authController.atualizarToken(refreshTokenDTO);
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}
}