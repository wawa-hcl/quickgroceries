package com.quickgroceries.product.exception;

/**
 * The Class ProductNotFoundException.
 */
public class ProductNotFoundException extends RuntimeException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new product not found exception.
	 *
	 * @param s the s
	 */
	public ProductNotFoundException(String s) {
		super(s);
	}
}
