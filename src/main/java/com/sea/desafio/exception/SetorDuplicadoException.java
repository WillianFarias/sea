package com.sea.desafio.exception;

public class SetorDuplicadoException extends RuntimeException {
	private static final long serialVersionUID = -2896827361160672376L;

	public SetorDuplicadoException(String mensagem) {
        super(mensagem);
    }
}

