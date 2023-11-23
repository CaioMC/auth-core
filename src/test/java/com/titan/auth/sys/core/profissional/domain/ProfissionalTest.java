package com.titan.auth.sys.core.profissional.domain;

import com.titan.auth.sys.core.auth.RegistrarUseCase;
import com.titan.auth.sys.core.profissional.domain.enums.ConcelhoProfissional;
import com.titan.auth.sys.core.profissional.domain.enums.ProfissaoEspecializada;
import com.titan.auth.sys.core.profissional.domain.enums.Sexo;
import com.titan.auth.sys.core.profissional.domain.enums.TratamentoProfissional;
import com.titan.auth.sys.core.profissional.domain.enums.Uf;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Profissional - Dominio")
class ProfissionalTest {

	private final String nome = "Charles Mack";
	private final String email = "charles.mock@gmail.com";
	private final String cpf = "03119850262";
	private final String celular = "47998465343";
	private final Sexo sexo = Sexo.MASCULINO;
	private final TratamentoProfissional tratamento = TratamentoProfissional.DR;
	private final ConcelhoProfissional concelhoProfissional = ConcelhoProfissional.CBOO;
	private final String registro = "123";
	private final Uf uf = Uf.ACRE;
	private final ProfissaoEspecializada profissao = ProfissaoEspecializada.ASSISTENTE_SOCIAL;
	private final String cbo = "123";
	private final String rqe = "123";
	private final String cnes = "123";


	@Test
	void testRegistrarClinicaPadrao() {
		var cmd = new RegistrarUseCase.RegistrarCommand(
				this.nome,
				this.email,
				this.cpf,
				this.celular,
				this.sexo,
				this.tratamento,
				this.concelhoProfissional,
				this.registro,
				this.uf,
				this.profissao,
				this.cbo,
				this.rqe,
				this.cnes,
				null
		);

		var profissional = Profissional.registrarProfissionalSaude(cmd);

		assertAll("Verifica se todos os atributos do profissional estão corretos",
				() -> assertEquals(this.nome, profissional.getNome()),
				() -> assertEquals(this.email, profissional.getEmail()),
				() -> assertEquals(this.cpf, profissional.getCpf()),
				() -> assertEquals(this.celular, profissional.getCelular()),
				() -> assertEquals(this.sexo, profissional.getSexo()),
				() -> assertEquals(this.tratamento, profissional.getTratamento()),
				() -> assertEquals(this.concelhoProfissional, profissional.getConcelhoProfissional()),
				() -> assertEquals(this.registro, profissional.getRegistro()),
				() -> assertEquals(this.uf, profissional.getUf()),
				() -> assertEquals(this.profissao, profissional.getProfissao()),
				() -> assertEquals(this.cbo, profissional.getCbo()),
				() -> assertEquals(this.rqe, profissional.getRqe()),
				() -> assertEquals(this.cnes, profissional.getCnes()));
	}
}
