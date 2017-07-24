package br.com.muxi.exception;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;

public class ErrorResponse {

	private HttpStatus status;
	private int statusCode;
	private List<String> erros;

	public ErrorResponse(HttpStatus status, List<String> erros) {
		this.status = status;
		this.statusCode = status.value();
		this.erros = erros;
	}

	public ErrorResponse(HttpStatus status, String error) {
		this.status = status;
		this.statusCode = status.value();
		erros = Arrays.asList(error);
	}

	public HttpStatus getStatus() {
		return status;
	}
	
	public int getStatusCode() {
		return statusCode;
	}

	public List<String> getErros() {
		return erros;
	}
}
