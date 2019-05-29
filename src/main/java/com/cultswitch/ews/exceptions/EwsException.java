package com.cultswitch.ews.exceptions;

import org.springframework.http.HttpStatus;

public class EwsException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String errorMsg;
	
	private HttpStatus httpStatus;

	
	public EwsException(String errorMsg,HttpStatus httpStatus) {
		this.errorMsg = errorMsg;
		this.httpStatus = httpStatus;
	}
	
	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}
	
	

}
