package com.titan.auth.sys.core.profissionalclinica.adapter.out.db;

import com.titan.auth.sys.core.profissionalclinica.domain.ProfissionalClinica;
import com.titan.auth.sys.core.profissionalclinica.domain.ProfissionalClinicaDomainRepository;
import org.springframework.data.repository.Repository;

import java.util.UUID;

public interface ProfissionalClinicaRepositoryJpa extends ProfissionalClinicaDomainRepository, Repository<ProfissionalClinica, UUID> {
}
