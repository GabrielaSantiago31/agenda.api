package com.treinamento.agenda.exception;

import org.springframework.http.HttpStatus;

public class ErroDeNegocioException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private HttpStatus httpStatus = null;
	private String erro = null;
	
	public ErroDeNegocioException() {
		
	}
	
	public ErroDeNegocioException(HttpStatus httpStatus, String erro) {
		this.httpStatus = httpStatus;
		this.erro = erro;
		
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public String getErro() {
		return erro;
	}

	@Override
	public String toString() {
		return "ErroDeNegocioException [httpStatus=" + httpStatus + ", erro=" + erro + "]";
	}
}
