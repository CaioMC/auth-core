package com.titan.auth.sys.core.clinica.domain;

import com.titan.auth.sys.core.infra.config.domain.entity.AbstractAuditableAggregate;
import com.titan.auth.sys.core.profissional.domain.enums.Uf;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import java.util.UUID;

@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity(name = "clinica")
public class Clinica extends AbstractAuditableAggregate {

	@Id
	private UUID  id;
	private String nome;
	private String email;
	private String numeroCnes;
	private String cep;
	private String endereco;
	private Integer numero;
	private String complemento;
	private String bairro;
	private String cidade;
	private Uf uf;

	public static Clinica registrarClinicaPadrao(@NotBlank String nome, @NotBlank String email) {
		return new Clinica(
				UUID.randomUUID(),
				nome + " Clinica",
				email,
				null,
				null,
				null,
				null,
				null,
				null,
				null,
				null
		);
	}

}
