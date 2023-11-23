package com.titan.auth.sys.core.profissional.domain;

import com.titan.auth.sys.core.auth.RegistrarUseCase.RegistrarCommand;
import com.titan.auth.sys.core.infra.config.domain.entity.AbstractAuditableAggregate;
import com.titan.auth.sys.core.profissional.domain.enums.ConcelhoProfissional;
import com.titan.auth.sys.core.profissional.domain.enums.ProfissaoEspecializada;
import com.titan.auth.sys.core.profissional.domain.enums.Sexo;
import com.titan.auth.sys.core.profissional.domain.enums.TipoProfissional;
import com.titan.auth.sys.core.profissional.domain.enums.TratamentoProfissional;
import com.titan.auth.sys.core.profissional.domain.enums.Uf;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.util.UUID;


@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity(name = "profissional")
public class Profissional extends AbstractAuditableAggregate {

	@Id
	private UUID id;
	private TipoProfissional tipo;
	private String email;
	private String nome;
	private String cpf;
	private String celular;
	private Sexo sexo;
	private TratamentoProfissional tratamento;
	private ConcelhoProfissional concelhoProfissional;
	private String registro;
	private Uf uf;
	private ProfissaoEspecializada profissao;
	private String cbo;
	private String rqe;
	private String cnes;

	public static Profissional registrarProfissionalSaude(@NotNull RegistrarCommand command) {
		return new Profissional(
				UUID.randomUUID(),
				TipoProfissional.PROFISSIONAL_SAUDE,
				command.email(),
				command.nome(),
				command.cpf(),
				command.celular(),
				command.sexo(),
				command.tratamento(),
				command.concelhoProfissional(),
				command.registro(),
				command.uf(),
				command.profissao(),
				command.cbo(),
				command.rqe(),
				command.cnes()
		);
	}

	public String getLogin() {
		return StringUtils.isNotBlank(this.cpf) ? this.cpf : this.email;
	}
}
