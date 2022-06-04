package org.serratec.lojasamazonas.exception;

public class EstoqueInsuficienteException extends Exception {

	private static final long serialVersionUID = 1L;

	public EstoqueInsuficienteException() {
		super();
	}

	public EstoqueInsuficienteException(String message) {
		super(message);
	}

}