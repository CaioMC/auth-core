package com.titan.auth.sys.core.infra.config.security.exception;

public class TokenInvalidoException extends RuntimeException {

    private static final long serialVersionUID = -4295480235655274005L;

    public TokenInvalidoException() {
        super("A autenticação realizada no sistema esta inválida.");
    }
}
