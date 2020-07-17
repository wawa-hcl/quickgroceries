package com.quickgroceries.product.exception.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.quickgroceries.product.exception.ProductNotFoundException;
import com.quickgroceries.product.model.ErrorDto;

@ControllerAdvice
public class ProductExceptionHandler {
	
	@ExceptionHandler(value=ProductNotFoundException.class)
	public ResponseEntity<ErrorDto> exception(ProductNotFoundException ex, WebRequest request)
	{
		ErrorDto erroeDto = new ErrorDto(new Date(), ex.getMessage(),request.getDescription(false));
		return new ResponseEntity<>(erroeDto,HttpStatus.NOT_FOUND);
	}

}
