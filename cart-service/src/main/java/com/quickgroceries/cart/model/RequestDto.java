package com.quickgroceries.cart.model;

public class RequestDto {
	private Long product_id;

	private int quantity;

	private Action action;

	public RequestDto() {
		super();
	}

	public RequestDto(Long product_id, int quantity, Action action) {
		super();
		this.product_id = product_id;
		this.quantity = quantity;
		this.action = action;
	}

	public Long getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Long product_id) {
		this.product_id = product_id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Action getAction() {
		return action;
	}

	public void setAction(Action action) {
		this.action = action;
	}

}
