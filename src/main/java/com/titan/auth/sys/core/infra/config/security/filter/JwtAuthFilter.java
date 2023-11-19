package com.titan.auth.sys.core.infra.config.security.filter;

import com.titan.auth.sys.core.auth.app.AutenticarAppService;
import com.titan.auth.sys.core.infra.config.security.app.JwtAppServive;
import com.titan.auth.sys.core.infra.config.security.exception.TokenInvalidoException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@AllArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter {

	private final JwtAppServive jwtAppServive;
	private final AutenticarAppService autenticarAppService;

	protected void doFilterInternal(
			HttpServletRequest request,
			HttpServletResponse response,
			FilterChain filterChain) throws ServletException, IOException {

		String authorization = request.getHeader("Authorization");

		if (authorization != null && authorization.startsWith("Bearer")) {

			String token = authorization.split(" ")[1];
			var isValid = this.jwtAppServive.tokenValido(token);

			if (isValid) {

				String loginUsuario = this.jwtAppServive.obterLoginUsuario(token);
				UserDetails usuario = this.autenticarAppService.loadUserByUsername(loginUsuario);

				UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
						User.builder()
								.username(usuario.getUsername())
								.password(usuario.getPassword())
								.build(),
						null,
						usuario.getAuthorities());

				authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				authenticationToken.setAuthenticated(true);

				SecurityContextHolder.getContext().setAuthentication(authenticationToken);
			} else {
				throw new TokenInvalidoException();
			}
		}

		filterChain.doFilter(request, response);
	}
}
