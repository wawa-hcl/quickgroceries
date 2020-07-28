package com.quickgroceries.customer.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends Exception {

	private static final long serialVersionUID = 3942780105760450101L;
	
	public ResourceNotFoundException(String message) {
	    super(message);
	  }

    public ResourceNotFoundException() {

    }
}
