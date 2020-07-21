package com.quickgroceries.order.model;

public class OrderIdDto {
	private String[] orderIds;

	public String[] getOrderIds() {
		return orderIds;
	}

	public void setOrderIds(String[] orderIds) {
		this.orderIds = orderIds;
	}

	public OrderIdDto(String[] orderIds) {
		super();
		this.orderIds = orderIds;
	}

	public OrderIdDto() {
		super();
	}
	
}
