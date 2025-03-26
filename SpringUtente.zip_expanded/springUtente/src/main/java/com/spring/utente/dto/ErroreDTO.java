package com.spring.utente.dto;

public class ErroreDTO {
	
	private String message;

	public ErroreDTO(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
