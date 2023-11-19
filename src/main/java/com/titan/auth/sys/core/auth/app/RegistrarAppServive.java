package com.titan.auth.sys.core.auth.app;

import com.titan.auth.sys.core.auth.AutenticarUseCase.AutenticarCommand;
import com.titan.auth.sys.core.auth.RegistrarUseCase;
import com.titan.auth.sys.core.auth.domain.Auth;
import com.titan.auth.sys.core.auth.domain.AuthDomainRepository;
import com.titan.auth.sys.core.clinica.domain.Clinica;
import com.titan.auth.sys.core.clinica.domain.ClinicaDomainRepository;
import com.titan.auth.sys.core.funcaoprofissional.domain.FuncaoProfissional;
import com.titan.auth.sys.core.funcaoprofissional.domain.FuncaoProfissionalDomainRepository;
import com.titan.auth.sys.core.funcaoprofissional.domain.enums.Funcao;
import com.titan.auth.sys.core.profissional.domain.Profissional;
import com.titan.auth.sys.core.profissional.domain.ProfissionalDomainRepository;
import com.titan.auth.sys.core.profissionalclinica.domain.ProfissionalClinica;
import com.titan.auth.sys.core.profissionalclinica.domain.ProfissionalClinicaDomainRepository;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class RegistrarAppServive implements RegistrarUseCase {

	private final ProfissionalDomainRepository repository;
	private final FuncaoProfissionalDomainRepository funcaoProfissionalRepository;
	private final AuthDomainRepository authRepository;
	private final ClinicaDomainRepository clinicaRepository;
	private final ProfissionalClinicaDomainRepository profissionalClinicaRepository;

	private final AutenticarAppService autenticarService;

	public UsuarioCadastradoResult handle(RegistrarCommand command) {
		var profisionalSaude = this.registrarProfissionalADM(command);
		var clinicaPadrao = this.clinicaRepository.save(Clinica.registrarClinicaPadrao(profisionalSaude.getNome(), profisionalSaude.getEmail()));

		this.registrarProfissionalEmClinica(clinicaPadrao, profisionalSaude);

		PasswordEncoder encoder = new BCryptPasswordEncoder();

		this.authRepository.save(
				Auth.registrarAuth(
						profisionalSaude.getId(),
						null,
						encoder.encode(command.senha()),
						clinicaPadrao.getId()
				));

		return this.autenticarUsuario(profisionalSaude, command.senha());
	}

	private void registrarProfissionalEmClinica(Clinica clinicaPadrao, Profissional profisionalSaude) {
		this.profissionalClinicaRepository.save(ProfissionalClinica.builder().clinicaId(clinicaPadrao.getId()).profissionalId(profisionalSaude.getId()).build());
	}

	private Profissional registrarProfissionalADM(RegistrarCommand command) {
		var profisionalSaude = this.repository.save(Profissional.registrarProfissionalSaude(command));
		this.funcaoProfissionalRepository.save(
				FuncaoProfissional.builder()
						.profissionalId(profisionalSaude.getId())
						.funcao(Funcao.ADMINISTRACAO)
						.build()
		);

		return profisionalSaude;
	}

	private UsuarioCadastradoResult autenticarUsuario(Profissional profissional, String senha) {
		var login = StringUtils.isNotBlank(profissional.getCpf()) ? profissional.getCpf() : profissional.getEmail();
		return this.autenticarService.handle(new AutenticarCommand(login, senha));
	}
}