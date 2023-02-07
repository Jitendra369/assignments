package com.crudoperations.model;

import org.springframework.http.HttpStatus;

public class ErrorResponse {
	
	private String errorName;
	private HttpStatus httpStatus;
	
	public String getErrorName() {
		return errorName;
	}
	

	public ErrorResponse(String errorName, HttpStatus httpStatus) {
		super();
		this.errorName = errorName;
		this.httpStatus = httpStatus;
	}


	public void setErrorName(String errorName) {
		this.errorName = errorName;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	public ErrorResponse() {
		// TODO Auto-generated constructor stub
	}
	
	

}
