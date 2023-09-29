package com.sea.desafio.exception;

public class TrabalhadorDuplicadoException extends RuntimeException {
	private static final long serialVersionUID = -2896827361160672376L;

	public TrabalhadorDuplicadoException(String mensagem) {
        super(mensagem);
    }
}
