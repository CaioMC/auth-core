package com.titan.auth.sys.core.funcaoprofissional.domain;

import com.titan.auth.sys.core.funcaoprofissional.domain.enums.Funcao;
import com.titan.auth.sys.core.infra.config.domain.entity.AbstractAuditableAggregate;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.util.UUID;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity(name = "funcao_profissional")
public class FuncaoProfissional extends AbstractAuditableAggregate {

	@Id
	private UUID id;
	private UUID profissionalId;
	private Funcao funcao;

	@Builder
	public static FuncaoProfissional registrarFuncao(UUID profissionalId, Funcao funcao) {
		return new FuncaoProfissional(
				UUID.randomUUID(),
				profissionalId,
				funcao
		);
	}

}
