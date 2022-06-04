package org.serratec.lojasamazonas.security;

public class UsuarioAuthenticationResponse {

	private final String token;

	private String getToken() {
		return token;

	}

	public UsuarioAuthenticationResponse(String token) {
		this.token = token;
	}

}
