package com.quickgroceries.product.exception.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.quickgroceries.product.exception.ProductNotFoundException;
import com.quickgroceries.product.model.ErrorDto;

/**
 * The Class ProductExceptionHandler.
 */
@ControllerAdvice
public class ProductExceptionHandler {

	/**
	 * Exception.
	 *
	 * @param ex      the ex
	 * @param request the request
	 * @return the response entity
	 */
	@ExceptionHandler(value = ProductNotFoundException.class)
	public ResponseEntity<ErrorDto> exception(ProductNotFoundException ex, WebRequest request) {
		ErrorDto errorDto = new ErrorDto(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDto, HttpStatus.NOT_FOUND);
	}

}
