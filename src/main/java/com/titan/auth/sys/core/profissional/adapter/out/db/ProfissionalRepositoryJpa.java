package com.titan.auth.sys.core.profissional.adapter.out.db;

import com.titan.auth.sys.core.profissional.domain.Profissional;
import com.titan.auth.sys.core.profissional.domain.ProfissionalDomainRepository;
import org.springframework.data.repository.Repository;

import java.util.UUID;

public interface ProfissionalRepositoryJpa extends ProfissionalDomainRepository, Repository<Profissional, UUID> {
}
