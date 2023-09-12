package com.titan.auth.sys.core.auth.adapter.out.db;

import com.titan.auth.sys.core.auth.domain.Auth;
import com.titan.auth.sys.core.auth.domain.AuthDomainRepository;
import org.springframework.data.repository.Repository;

import java.util.UUID;

public interface AuthRepositoryJpa extends AuthDomainRepository, Repository<Auth, UUID> {
}
