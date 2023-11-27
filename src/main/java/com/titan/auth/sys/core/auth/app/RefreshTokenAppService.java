package com.titan.auth.sys.core.auth.app;

import com.titan.auth.sys.core.auth.RefreshTokenUseCase;
import com.titan.auth.sys.core.auth.RegistrarUseCase;
import com.titan.auth.sys.core.auth.domain.AuthDomainRepository;
import com.titan.auth.sys.core.auth.exception.TokenNaoGeradoPeloSistemaTitanException;
import com.titan.auth.sys.core.infra.config.security.app.JwtAppServive;
import io.jsonwebtoken.Claims;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Service
@Transactional
@AllArgsConstructor
public class RefreshTokenAppService implements RefreshTokenUseCase {

	private final AuthDomainRepository repository;
	private final JwtAppServive jwtAppService;

	public RegistrarUseCase.UsuarioCadastradoResult handle(RefreshTokenCommand command) throws TokenNaoGeradoPeloSistemaTitanException {
		try {
			Claims claims = JwtAppServive.obterClaims(command.token());

			String authId = claims.getSubject();
			Date dataExpiracao = claims.getExpiration();

			LocalDateTime data =
					dataExpiracao.toInstant()
							.atZone(ZoneId.systemDefault()).toLocalDateTime();

			if (!LocalDateTime.now().isAfter(data))
				return new RegistrarUseCase.UsuarioCadastradoResult(command.token(), null);

			return new RegistrarUseCase.UsuarioCadastradoResult(
					this.jwtAppService.gerarToken(
							User
									.builder()
									.username(authId)
									.build()
					),
					null
			);
		} catch (Exception e) {
			throw new TokenNaoGeradoPeloSistemaTitanException();
		}
	}
}
