package com.titan.auth.sys.core.clinica.adapter.out.db;

import com.titan.auth.sys.core.clinica.domain.Clinica;
import com.titan.auth.sys.core.clinica.domain.ClinicaDomainRepository;
import org.springframework.data.repository.Repository;

import java.util.UUID;

public interface ClinicaRepositoryJpa extends ClinicaDomainRepository, Repository<Clinica, UUID> {
}
