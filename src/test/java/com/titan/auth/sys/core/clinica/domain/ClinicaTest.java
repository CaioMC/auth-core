package com.titan.auth.sys.core.clinica.domain;

import com.titan.auth.sys.core.profissional.domain.enums.Uf;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Clinica - Dominio")
class ClinicaTest {

	private final String nome = "Marcos Augusto";
	private final String email = "marcos@gmail.com";
	private final String numeroCnes = "123";
	private final String cep = "89221-009";
	private final String endereco = "Endereco";
	private final Integer numero = 123;
	private final String complemento = "Complemento";
	private final String bairro = "Saguacu";
	private final String cidade = "Joinville";
	private final Uf uf = Uf.ACRE;


	@Test
	void testRegistrarClinicaPadrao() {
		var clinica = Clinica.registrarClinicaPadrao(
				this.nome,
				this.email
		);

		assertAll("Verifica se todos os atributos da clinica estão corretos",
				() -> assertEquals(this.nome + " Clinica", clinica.getNome()),
				() -> assertEquals(this.email, clinica.getEmail()));
	}

	@Test
	void testAll() {
		var clinica = Clinica.builder()
				.id(UUID.randomUUID())
				.nome(nome)
				.email(email)
				.numeroCnes(numeroCnes)
				.cep(cep)
				.endereco(endereco)
				.numero(numero)
				.complemento(complemento)
				.bairro(bairro)
				.cidade(cidade)
				.uf(uf)
				.build();

		assertAll("Verifica se todos os atributos da clinica estão corretos",
				() -> assertEquals(this.nome, clinica.getNome()),
				() -> assertEquals(this.email, clinica.getEmail()),
				() -> assertEquals(this.numeroCnes, clinica.getNumeroCnes()),
				() -> assertEquals(this.cep, clinica.getCep()),
				() -> assertEquals(this.endereco, clinica.getEndereco()),
				() -> assertEquals(this.complemento, clinica.getComplemento()),
				() -> assertEquals(this.bairro, clinica.getBairro()),
				() -> assertEquals(this.cidade, clinica.getCidade()),
				() -> assertEquals(this.uf, clinica.getUf()));

	}
}