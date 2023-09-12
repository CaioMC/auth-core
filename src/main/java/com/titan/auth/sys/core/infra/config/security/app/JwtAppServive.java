package com.titan.auth.sys.core.infra.config.security.app;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

@Service
@Transactional
@RequiredArgsConstructor
public class JwtAppServive {

	private static final int EXPIRACAO = 360; // 6 horas
	private static final String CHAVE_ASSINATURA = "aEkyQ1hTcnF1aXRNcGFYNW5Zcm9wVUc=";

	public String gerarToken(UserDetails usuario) {
		Date date = new Date();

		Calendar calendar = Calendar.getInstance();

		calendar.setTime(date);
		calendar.add(Calendar.MINUTE, EXPIRACAO);

		Date newDate = calendar.getTime();

		return Jwts
				.builder()
				.setSubject(usuario.getUsername())
				.setExpiration(newDate)
				.signWith(SignatureAlgorithm.HS512, CHAVE_ASSINATURA)
				.compact();
	}

	public boolean tokenValido(String token) {
		try {
			Claims claims = this.obterClaims(token);
			Date dataExpiracao = claims.getExpiration();
			LocalDateTime data =
					dataExpiracao.toInstant()
							.atZone(ZoneId.systemDefault()).toLocalDateTime();
			return !LocalDateTime.now().isAfter(data);
		} catch (Exception e) {
			return false;
		}
	}

	public String obterLoginUsuario(String token) throws ExpiredJwtException {
		return (String) this.obterClaims(token).getSubject();
	}

	private Claims obterClaims(String token) throws ExpiredJwtException {
		return Jwts
				.parser()
				.setSigningKey(CHAVE_ASSINATURA)
				.parseClaimsJws(token)
				.getBody();
	}

}
