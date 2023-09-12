package com.titan.auth.sys.core.auth;

import com.titan.auth.sys.core.auth.adapter.api.dto.RegistrarDTO;
import com.titan.auth.sys.core.profissional.domain.enums.ConcelhoProfissional;
import com.titan.auth.sys.core.profissional.domain.enums.ProfissaoEspecializada;
import com.titan.auth.sys.core.profissional.domain.enums.Sexo;
import com.titan.auth.sys.core.profissional.domain.enums.TratamentoProfissional;
import com.titan.auth.sys.core.profissional.domain.enums.Uf;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface RegistrarUseCase {

	UsuarioCadastradoResult handle(RegistrarCommand command);

	record RegistrarCommand(
			String nome,
			String email,
			String cpf,
			String celular,
			Sexo sexo,
			TratamentoProfissional tratamento,
			ConcelhoProfissional concelhoProfissional,
			String registro,
			Uf uf,
			ProfissaoEspecializada profissao,
			String cbo,
			String rqe,
			String cnes,
			String senha
	) {
		public static RegistrarCommand toCommand(RegistrarDTO dto) {
			return new RegistrarCommand(
					dto.nome(),
					dto.email(),
					dto.cpf(),
					dto.celular(),
					dto.sexo(),
					dto.tratamento(),
					dto.concelhoProfissional(),
					dto.registro(),
					dto.uf(),
					dto.profissao(),
					dto.cbo(),
					dto.rqe(),
					dto.cnes(),
					dto.senha()
			);
		}
	}

	record UsuarioCadastradoResult(
			String login,
			String senha
	) {}

}
