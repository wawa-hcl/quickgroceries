package com.quickgroceries.cart.model;

public class UpdateStateRequestDto {

	private Long cartIds;

	public UpdateStateRequestDto() {
		super();
	}

	public UpdateStateRequestDto(Long cartIds) {
		super();
		this.cartIds = cartIds;
	}

	public Long getCartIds() {
		return cartIds;
	}

	public void setCartIds(Long cartIds) {
		this.cartIds = cartIds;
	}
	
	
}
