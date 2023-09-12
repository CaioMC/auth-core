package com.titan.auth.sys.core.auth.domain;

import com.titan.auth.sys.core.auth.AutenticarUseCase;
import com.titan.auth.sys.core.auth.exception.UsuarioNaoEncontradoException;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface AuthDomainRepository {

	Auth save(Auth login);

	@Query(value =
			"SELECT tt.id as id, p.cpf as cpf, p.email as email, tt.password " +
			"FROM {h-schema}auth tt " +
			"INNER JOIN {h-schema}profissional p ON (tt.profissional_id = p.id) " +
			"INNER JOIN {h-schema}clinica cn ON (tt.clinica_id = cn.id) " +
			"WHERE p.cpf = :cpfOrEmail " +
			"OR p.email = :cpfOrEmail",
			nativeQuery = true)
	Optional<AutenticarUseCase.AuthProjection> findByLogin(String cpfOrEmail);

	Optional<Auth> findById(UUID id);

	default Auth findByIdOrThrowNotFound(UUID id) {
		return this.findById(id).orElseThrow(UsuarioNaoEncontradoException::new);
	}

	default AutenticarUseCase.AuthProjection findByLoginOrThrowNotFound(String cpfOrEmail) {
		return this.findByLogin(cpfOrEmail).orElseThrow(UsuarioNaoEncontradoException::new);
	}

}
