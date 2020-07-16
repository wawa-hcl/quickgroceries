package com.quickgroceries.customer.exceptions;

import org.springframework.http.HttpStatus;


public class ErrorResponse {
	
	private HttpStatus status;
	private String message;
	private String detail;
	
	public ErrorResponse() {
		
	}

	public ErrorResponse(HttpStatus notFound, String message, String detail) {
		super();
		this.status = notFound;
		this.message = message;
		this.detail = detail;
	}



	public HttpStatus getHttpCode() {
		return status;
	}

	public void setHttpCode(HttpStatus httpCode) {
		this.status = httpCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}
    
	
}
