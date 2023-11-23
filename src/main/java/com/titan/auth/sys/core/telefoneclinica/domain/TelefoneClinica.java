package com.titan.auth.sys.core.telefoneclinica.domain;

import com.titan.auth.sys.core.infra.config.domain.entity.AbstractAuditableAggregate;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity(name = "telefone_clinica")
public class TelefoneClinica extends AbstractAuditableAggregate {

	@Id
	private UUID id;
	private UUID clinicaId;
	private String telefone;

	public static TelefoneClinica registrarTelefoneClinica(UUID clinicaId, String telefone) {
		return new TelefoneClinica(
				UUID.randomUUID(),
				clinicaId,
				telefone
		);
	}
}