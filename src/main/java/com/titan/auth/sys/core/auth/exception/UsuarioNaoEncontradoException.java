package com.titan.auth.sys.core.auth.exception;

public class UsuarioNaoEncontradoException extends RuntimeException {

    private static final long serialVersionUID = 5092749380145830865L;

    public UsuarioNaoEncontradoException() {
        super("Usuário não encontrado na base de dados.");
    }
}
