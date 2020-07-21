package com.quickgroceries.cart.exception;

public class CartNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CartNotFoundException(String s) {
		super(s);
	}
}
