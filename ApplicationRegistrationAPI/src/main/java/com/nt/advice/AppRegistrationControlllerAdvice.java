package com.nt.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.nt.service.InvalidServiceNumberException;

@RestControllerAdvice
public class AppRegistrationControlllerAdvice {
	
	@ExceptionHandler(InvalidServiceNumberException.class)
	public ResponseEntity<String> handleInvalidSerNoException(InvalidServiceNumberException exception){
		return new ResponseEntity<String>(exception.getMessage(),HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleAllException(Exception exception){
		return new ResponseEntity<String>(exception.getMessage(),HttpStatus.BAD_REQUEST);
	}
}
