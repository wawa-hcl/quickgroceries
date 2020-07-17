package com.quickgroceries.cart.model;

import java.util.List;

public class StateCartResponseDto {
	
	private Long cartID;

	private Long customerID;

	private Double cart_amount;

	private List<CartItemsDto> cartItems;

	public StateCartResponseDto() {
		super();
	}

	public StateCartResponseDto(Long cartID, Long customerID, Double cart_amount, List<CartItemsDto> cartItems) {
		super();
		this.cartID = cartID;
		this.customerID = customerID;
		this.cart_amount = cart_amount;
		this.cartItems = cartItems;
	}

	public Long getCartID() {
		return cartID;
	}

	public void setCartID(Long cartID) {
		this.cartID = cartID;
	}

	public Long getCustomerID() {
		return customerID;
	}

	public void setCustomerID(Long customerID) {
		this.customerID = customerID;
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
		return "StateCartResponseDto [cartID=" + cartID + ", customerID=" + customerID + ", cart_amount=" + cart_amount
				+ ", cartItems=" + cartItems + "]";
	}
	
	

}
