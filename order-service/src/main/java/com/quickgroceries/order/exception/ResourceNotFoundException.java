package com.quickgroceries.order.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class ResourceNotFoundException extends RuntimeException{
  private static final long serialVersioUID =1L;
  public ResourceNotFoundException(String message) {
	  super(message);
  }
  public ResourceNotFoundException(String message, Throwable throwable) {
	  super(message,throwable);
  }
}
