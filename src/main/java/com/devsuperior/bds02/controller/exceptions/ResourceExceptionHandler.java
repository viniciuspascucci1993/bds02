package com.devsuperior.bds02.controller.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.devsuperior.bds02.services.exceptions.DatabaseIntegrityException;
import com.devsuperior.bds02.services.exceptions.ResourceNotFoundException;


@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> entityNotFoundException( ResourceNotFoundException e , HttpServletRequest request ) {
		
		HttpStatus status = HttpStatus.NOT_FOUND;
		
		StandardError standardError = new StandardError();
		standardError.setTimeStamp(Instant.now());
		standardError.setStatus(status.value());
		standardError.setError("Resource Not Found");
		standardError.setMessage(e.getMessage());
		standardError.setPath(request.getRequestURI());
		
		return ResponseEntity.status(status).body(standardError);
	}
	
	@ExceptionHandler(DatabaseIntegrityException.class)
	public ResponseEntity<StandardError> dataBaseIntegrityException( DatabaseIntegrityException e , HttpServletRequest request ) {
		
		HttpStatus status = HttpStatus.BAD_REQUEST;
		
		StandardError standardError = new StandardError();
		standardError.setTimeStamp(Instant.now());
		standardError.setStatus(status.value());
		standardError.setError("Database Exception");
		standardError.setMessage(e.getMessage());
		standardError.setPath(request.getRequestURI());
		
		return ResponseEntity.status(status).body(standardError);
	}
}
