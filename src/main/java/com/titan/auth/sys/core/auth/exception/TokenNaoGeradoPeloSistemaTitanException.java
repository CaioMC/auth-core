package com.titan.auth.sys.core.auth.exception;

public class TokenNaoGeradoPeloSistemaTitanException extends RuntimeException {

    private static final long serialVersionUID = -3551133870896552112L;

    public TokenNaoGeradoPeloSistemaTitanException() {
        super("O token informado não foi gerado pelo sistema Titan.");
    }
}
