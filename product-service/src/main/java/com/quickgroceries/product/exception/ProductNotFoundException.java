package com.quickgroceries.product.exception;

public class ProductNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ProductNotFoundException(String s){
		super(s);
	}
}
