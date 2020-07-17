package com.quickgroceries.cart.model;

import java.util.List;

public class ResponseDto {

	private Double cart_amount;

	private List<CartItemsDto> cartItems;

	public ResponseDto() {
		super();
	}

	public ResponseDto(Double cart_amount, List<CartItemsDto> cartItems) {
		super();
		this.cart_amount = cart_amount;
		this.cartItems = cartItems;
	}

	public Double getCart_amount() {
		return cart_amount;
	}

	public void setCart_amount(Double cart_amount) {
		this.cart_amount = cart_amount;
	}

	public List<CartItemsDto> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartItemsDto> cartItems) {
		this.cartItems = cartItems;
	}

	@Override
	public String toString() {
		return "ResponseDto [cart_amount=" + cart_amount + ", cartItems=" + cartItems + "]";
	}
	
	

}
