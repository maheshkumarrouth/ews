package com.cultswitch.ews.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler {
	
	@ExceptionHandler(EwsException.class)
	public final ResponseEntity<String> handleEwsException(EwsException ewsException){
		return new ResponseEntity<>(ewsException.getErrorMsg(), ewsException.getHttpStatus());
	}
}
