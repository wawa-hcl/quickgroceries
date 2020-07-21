package com.quickgroceries.cart.model;

public class CartIdDto {

	private Long[] cartIds;

	public CartIdDto(Long[] cartIds) {
		super();
		this.cartIds = cartIds;
	}

	public CartIdDto() {
		super();
	}

	public Long[] getCartIds() {
		return cartIds;
	}

	public void setCartIds(Long[] cartIds) {
		this.cartIds = cartIds;
	}
	
	
}
