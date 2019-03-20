package com.example.jobapi.utils;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ExceptionAdvice {

	@ExceptionHandler({ Exception.class })
	public  ResponseEntity<SecurityErrorResponse> handleException(Exception exc) {
		SecurityErrorResponse error = new SecurityErrorResponse();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage("not ALLOW");
		error.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

	

}
