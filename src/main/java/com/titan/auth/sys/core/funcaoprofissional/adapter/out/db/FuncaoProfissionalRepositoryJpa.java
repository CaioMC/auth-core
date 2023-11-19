package com.titan.auth.sys.core.funcaoprofissional.adapter.out.db;

import com.titan.auth.sys.core.funcaoprofissional.domain.FuncaoProfissional;
import com.titan.auth.sys.core.funcaoprofissional.domain.FuncaoProfissionalDomainRepository;
import com.titan.auth.sys.core.profissional.domain.Profissional;
import com.titan.auth.sys.core.profissional.domain.ProfissionalDomainRepository;
import org.springframework.data.repository.Repository;

import java.util.UUID;

public interface FuncaoProfissionalRepositoryJpa extends FuncaoProfissionalDomainRepository, Repository<FuncaoProfissional, UUID> {
}
