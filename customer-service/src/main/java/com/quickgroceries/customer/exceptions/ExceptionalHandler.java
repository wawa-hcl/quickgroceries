package com.quickgroceries.customer.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ExceptionalHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	  public ResponseEntity<?> resourceNotFoundException(WebRequest request) {
	    ErrorResponse errorDetails = new ErrorResponse(HttpStatus.NOT_FOUND,"Entered Value is Not Found",request.getDescription(false));
	    return new ResponseEntity<Object>(errorDetails,HttpStatus.NOT_FOUND);
	  }


	@ExceptionHandler(Exception.class)
	  public ResponseEntity<?> globleExcpetionHandler(Exception ex, WebRequest request) {
	    ErrorResponse errorDetails =
	        new ErrorResponse( HttpStatus.INTERNAL_SERVER_ERROR ,ex.getMessage(), request.getDescription(false));
	    return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	  }
	
}
