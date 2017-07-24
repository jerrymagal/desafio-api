package br.com.muxi.exception;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApplicationExceptionHandler {
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<ErrorResponse> handleConstraintViolation(ConstraintViolationException e) {
		
		List<String> erros = new ArrayList<>();
		
		for(ConstraintViolation<?> violation : e.getConstraintViolations()) {
			erros.add(violation.getMessage());
		}
		
		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST, erros);
		
		return new ResponseEntity<ErrorResponse>(errorResponse, errorResponse.getStatus());
	}
}
