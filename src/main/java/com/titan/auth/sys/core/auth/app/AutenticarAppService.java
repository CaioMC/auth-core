package com.titan.auth.sys.core.auth.app;

import com.titan.auth.sys.core.auth.AutenticarUseCase;
import com.titan.auth.sys.core.auth.RegistrarUseCase.UsuarioCadastradoResult;
import com.titan.auth.sys.core.auth.domain.Auth;
import com.titan.auth.sys.core.auth.domain.AuthDomainRepository;
import com.titan.auth.sys.core.auth.exception.SenhaInvalidaException;
import com.titan.auth.sys.core.infra.config.security.app.JwtAppServive;
import com.titan.auth.sys.core.profissional.domain.ProfissionalDomainRepository;
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
	private final ProfissionalDomainRepository profissionalRepository;

	private final JwtAppServive jwtAppService;

	public UsuarioCadastradoResult handle(AutenticarCommand command) {
		PasswordEncoder encoder = new BCryptPasswordEncoder();

		UserDetails user = this.loadUserByUsername(command.login());
		this.validarSenha(command, encoder, user);

		String token = this.jwtAppService.gerarToken(user);

		UUID authId = UUID.fromString(user.getUsername());
		var auth = this.repository.findByIdOrThrowNotFound(authId);

		this.atualizarToken(auth, token);

		var profissional = this.profissionalRepository.findById(auth.getProfissionalId()).orElseThrow();

		return new UsuarioCadastradoResult(
				token,
				profissional.getNome()
		);
	}

	private void validarSenha(AutenticarCommand command, PasswordEncoder encoder, UserDetails user) {
		boolean senhaExistente = encoder.matches(command.senha(), user.getPassword());

		if (!senhaExistente)
			throw new SenhaInvalidaException();
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AuthProjection authProjetion = this.repository.findByLoginOrThrowNotFound(username);

		return User
				.builder()
				.username(authProjetion.getId().toString())
				.password(authProjetion.getPassword())
				.build();
	}

	private void atualizarToken(Auth auth, String token) {
		this.repository.save(auth.atualizarToken(token));
	}
}
