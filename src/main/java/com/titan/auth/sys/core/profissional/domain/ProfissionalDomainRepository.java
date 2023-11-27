package com.titan.auth.sys.core.profissional.domain;

import java.util.Optional;
import java.util.UUID;

public interface ProfissionalDomainRepository {

	Profissional save(Profissional profissional);

	Optional<Profissional> findById(UUID id);
}
