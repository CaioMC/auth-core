package com.titan.auth.sys.core.auth.app;

import com.titan.auth.sys.core.auth.AutenticarUseCase;
import com.titan.auth.sys.core.auth.domain.AuthDomainRepository;
import com.titan.auth.sys.core.auth.exception.SenhaInvalidaException;
import com.titan.auth.sys.core.infra.config.security.app.JwtAppServive;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class AutenticarAppService implements AutenticarUseCase {

	private final AuthDomainRepository repository;
	private final JwtAppServive jwtAppService;

	public UserDetails handle(AutenticarCommand command) {
		PasswordEncoder encoder = new BCryptPasswordEncoder();

		UserDetails user = this.loadUserByUsername(command.login());
		boolean senhaExistente = encoder.matches(command.senha(), user.getPassword());

		if (!senhaExistente)
			throw new SenhaInvalidaException();

		String token = this.jwtAppService.gerarToken(user);

		UUID authId = UUID.fromString(user.getUsername().split(" ")[1]);

		var auth = this.repository.findByIdOrThrowNotFound(authId);
		this.repository.save(auth.atualizarToken(token));

		return user;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AuthProjection authProjetion = this.repository.findByLoginOrThrowNotFound(username);

		return User
				.builder()
				.username(this.getUserName(authProjetion, username) + " " + authProjetion.getId().toString())
				.password(authProjetion.getPassword())
				.build();
	}

	private String getUserName(AuthProjection projection, String username) {
		return username.equals(projection.getCpf()) ? projection.getCpf() : projection.getEmail();
	}
}
