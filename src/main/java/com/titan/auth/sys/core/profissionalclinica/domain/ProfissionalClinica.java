package com.titan.auth.sys.core.profissionalclinica.domain;

import com.titan.auth.sys.core.infra.config.domain.entity.AbstractAuditableAggregate;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity(name = "profissional_clinica")
public class ProfissionalClinica extends AbstractAuditableAggregate {

	@Id
	private UUID id;
	private UUID clinicaId;
	private UUID profissionalId;

	@Builder
	private static ProfissionalClinica registrarProfissionalClinica(UUID clinicaId, UUID profissionalId) {
		return new ProfissionalClinica(
				UUID.randomUUID(),
				clinicaId,
				profissionalId
		);
	}
}
