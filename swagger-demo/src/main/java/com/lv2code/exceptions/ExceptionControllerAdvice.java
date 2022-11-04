package com.lv2code.exceptions;

import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.lv2code.dto.ErrorMessage;

@RestControllerAdvice
public class ExceptionControllerAdvice {
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorMessage> exceptionHandler(Exception ex) {
		ErrorMessage error = new ErrorMessage();
		error.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		error.setMessage(ex.getMessage());
		
		return new ResponseEntity<>(error, HttpStatus.OK);
	}
	
	@ExceptionHandler(NoSuchCustomerException.class)
	public ResponseEntity<ErrorMessage> exceptionHandler2(NoSuchCustomerException ex) {
		ErrorMessage errMsg = new ErrorMessage();
		errMsg.setErrorCode(HttpStatus.BAD_REQUEST.value());
		errMsg.setMessage(ex.getMessage());
		return new ResponseEntity<>(errMsg, HttpStatus.BAD_REQUEST);		
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorMessage> handleValidationExceptions(MethodArgumentNotValidException ex) {
		ErrorMessage errMsg = new ErrorMessage();
		errMsg.setErrorCode(HttpStatus.BAD_REQUEST.value());
		errMsg.setMessage(ex.getBindingResult().getAllErrors().stream().map(ObjectError::getDefaultMessage).collect(Collectors.joining(",")));
		return new ResponseEntity<>(errMsg, HttpStatus.BAD_REQUEST);		
	}
}
