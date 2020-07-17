package com.quickgroceries.cart.model;

public class CartItemsDto {

	private Long productID;

	private int quantity;

	public CartItemsDto(Long productID, int quantity) {
		super();
		this.productID = productID;
		this.quantity = quantity;
	}

	public CartItemsDto() {
		super();
	}

	public Long getProductID() {
		return productID;
	}

	public void setProductID(Long productID) {
		this.productID = productID;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
