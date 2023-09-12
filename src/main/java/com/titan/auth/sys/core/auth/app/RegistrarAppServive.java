package com.titan.auth.sys.core.auth.app;

import com.titan.auth.sys.core.auth.RegistrarUseCase;
import com.titan.auth.sys.core.auth.domain.Auth;
import com.titan.auth.sys.core.auth.domain.AuthDomainRepository;
import com.titan.auth.sys.core.clinica.domain.Clinica;
import com.titan.auth.sys.core.clinica.domain.ClinicaDomainRepository;
import com.titan.auth.sys.core.profissional.domain.Profissional;
import com.titan.auth.sys.core.profissional.domain.ProfissionalDomainRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class RegistrarAppServive implements RegistrarUseCase {

	private final ProfissionalDomainRepository repository;
	private final AuthDomainRepository authRepository;
	private final ClinicaDomainRepository clinicaRepository;

	public UsuarioCadastradoResult handle(RegistrarCommand command) {
		var profisionalSaude = this.repository.save(Profissional.registrarProfissionalSaude(command));
		var clinicaPadrao = this.clinicaRepository.save(Clinica.registrarClinicaPadrao(profisionalSaude.getNome(), profisionalSaude.getEmail()));

		PasswordEncoder encoder = new BCryptPasswordEncoder();

		var auth = this.authRepository.save(
				Auth.registrarAuth(
						profisionalSaude.getId(),
						null,
						encoder.encode(command.senha()),
						clinicaPadrao.getId()
				));

		return new UsuarioCadastradoResult(
				profisionalSaude.getLogin(),
				auth.getPassword()
		);
	}

}
