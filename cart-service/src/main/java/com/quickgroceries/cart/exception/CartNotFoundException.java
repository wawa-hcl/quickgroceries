package com.quickgroceries.cart.exception;

/**
 * The Class CartNotFoundException.
 */
public class CartNotFoundException extends RuntimeException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new cart not found exception.
	 *
	 * @param s the s
	 */
	public CartNotFoundException(String s) {
		super(s);
	}
}
