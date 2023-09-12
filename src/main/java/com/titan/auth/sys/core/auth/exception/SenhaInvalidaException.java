package com.titan.auth.sys.core.auth.exception;

public class SenhaInvalidaException extends RuntimeException {

    private static final long serialVersionUID = -7544376997801840517L;

    public SenhaInvalidaException() {
        super("Senha de usuário inválida.");
    }
}
