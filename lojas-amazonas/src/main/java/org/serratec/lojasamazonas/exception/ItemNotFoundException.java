package org.serratec.lojasamazonas.exception;

public class ItemNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public ItemNotFoundException() {
		super();
	}

	public ItemNotFoundException(String message) {
		super(message);
	}

}