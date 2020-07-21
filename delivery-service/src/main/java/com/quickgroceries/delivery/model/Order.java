package com.quickgroceries.delivery.model;



public class Order {
	private String orderId;
	private ResponseDto orderDetails;
	private State orderState;
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public ResponseDto getOrderDetails() {
		return orderDetails;
	}
	public void setOrderDetails(ResponseDto orderDetails) {
		this.orderDetails = orderDetails;
	}
	public State getOrderState() {
		return orderState;
	}
	public void setOrderState(State orderState) {
		this.orderState = orderState;
	}
	
}
