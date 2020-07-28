package com.quickgroceries.cart.exception.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.quickgroceries.cart.exception.CartNotFoundException;
import com.quickgroceries.cart.model.ErrorDto;

/**
 * The Class CartExceptionHandler.
 */
@ControllerAdvice
public class CartExceptionHandler {

	/**
	 * Exception.
	 *
	 * @param ex      the ex
	 * @param request the request
	 * @return the response entity
	 */
	@ExceptionHandler(value = CartNotFoundException.class)
	public ResponseEntity<ErrorDto> exception(CartNotFoundException ex, WebRequest request) {
		ErrorDto errorDto = new ErrorDto(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDto, HttpStatus.NOT_FOUND);
	}

}
