package com.titan.auth.sys.core.auth.app;

import com.titan.auth.sys.core.auth.RefreshTokenUseCase;
import com.titan.auth.sys.core.auth.exception.TokenNaoGeradoPeloSistemaTitanException;
import jakarta.servlet.ServletException;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
@Transactional
@Rollback
@ActiveProfiles("it")
class RefreshTokenAppServiceTest {

	@InjectMocks
	private RefreshTokenAppService refreshTokenAppService;

	@Test
	void testTokenInvalido() throws Exception {
		var refreshTokenCommand = new RefreshTokenUseCase.RefreshTokenCommand("eyJhdabGciOiJIUzUxMiJ9.eyJzdWIiOiIwZTIzMTc4OC04M2IzLTQ1YjEtOTAwZC0xYWQ5NTc0YTM2YjkiLCJleHAiOjE3MDA3NzIyMDN9.RvsLl9BbWVp8Htzp_6l1yGQQWrR1kJz8ZLH-Xu6dKg8iHuxgE_olVYY8Qi6pyC8ROlgjrXOjylm009DaLUfqPg");


		assertThrows(TokenNaoGeradoPeloSistemaTitanException.class,
				() -> refreshTokenAppService.handle(refreshTokenCommand));

	}
}
