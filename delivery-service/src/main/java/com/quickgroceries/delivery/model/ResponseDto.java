package com.quickgroceries.delivery.model;

import java.util.List;


public class ResponseDto {
	private Long cartID;
	private Long customerID;
    private Double cart_amount;
    private List<CartItemsDto> cartItems;
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
    
    
}
