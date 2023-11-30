package com.titan.auth.sys.core.auth.adpter.in.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.titan.auth.sys.core.auth.AutenticarUseCase;
import com.titan.auth.sys.core.auth.RegistrarUseCase;
import com.titan.auth.sys.core.auth.adapter.api.AuthController;
import com.titan.auth.sys.core.auth.adapter.api.dto.AutenticarDTO;
import com.titan.auth.sys.core.auth.adapter.api.dto.RefreshTokenDTO;
import com.titan.auth.sys.core.auth.adapter.api.dto.RegistrarDTO;
import com.titan.auth.sys.core.auth.domain.AuthDomainRepository;
import com.titan.auth.sys.core.profissional.domain.ProfissionalDomainRepository;
import com.titan.auth.sys.core.profissional.domain.enums.ConcelhoProfissional;
import com.titan.auth.sys.core.profissional.domain.enums.ProfissaoEspecializada;
import com.titan.auth.sys.core.profissional.domain.enums.Sexo;
import com.titan.auth.sys.core.profissional.domain.enums.TratamentoProfissional;
import com.titan.auth.sys.core.profissional.domain.enums.Uf;
import jakarta.servlet.ServletException;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
@Transactional
@Rollback
@ActiveProfiles("it")
class AuthControllerTest {

	@InjectMocks
	private AuthController authController;

	@Mock
	private AuthDomainRepository repository;

	@Mock
	private ProfissionalDomainRepository profissionalRepository;

	@Mock AutenticarUseCase autenticarUseCase;

	@Autowired
	private MockMvc mock;

	@Autowired
	ObjectMapper mapper;

	@Test
	void testRegistrarFuncionarioSuccess() throws Exception {
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

		String dto = mapper.writeValueAsString(registrarDTO);

		mock.perform(post("/api/auth/sign-up")
						.contentType(MediaType.APPLICATION_JSON)
						.content(dto))
				.andExpect(status().isOk())
				.andReturn();
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
	void testRefreshTokenSuccess() throws Exception {
		RefreshTokenDTO refreshTokenDTO =  new RefreshTokenDTO("eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiI3NjhjY2RiNy1hNGUzLTQ4N2EtOWY3Ni1lMjE4YzFlZDhiOTEiLCJleHAiOjE3MDEzOTU0NTh9.c4J73XoFL6AMVzCDLcwJ6QQ_L710jTDJzeSXYRBs486HBPhhbuyfA0zh6EUD1yQsbwMzcV2_5ZAb4wNs969gjQ");

		String dto = mapper.writeValueAsString(refreshTokenDTO );

		mock.perform(post("/api/auth/refresh-token")
						.contentType(MediaType.APPLICATION_JSON)
						.content(dto))
				.andExpect(status().isOk())
				.andReturn();
	}

	@Test
	void testTokenInvalido() throws Exception {
		RefreshTokenDTO refreshTokenDTO = new RefreshTokenDTO("eyJssshbGciOiJIUzUxMiJ9.eyJzdWIiOiI2NGVkZWZjYy1mYmY2LTRkMDgtYTI1ZS04NDIzNTEwNzFmddOTgiLCJleHAiOjE3MDEzMjM1NDd9.XhWSuuxqrJnl6PqCDcq-RPQ-oIoHdQOV5M_GMjsxypSk7D5jLw0kT0HrWSQcRyYV2Q0pCqpyVFSWazXKsDdOOw");

		String dto = mapper.writeValueAsString(refreshTokenDTO);
		assertThrows(ServletException.class,
				() -> mock.perform(post("/api/auth/refresh-token")
								.contentType(MediaType.APPLICATION_JSON)
								.content(dto))
						.andExpect(status().isBadRequest())
						.andReturn());

	}
}
