package com.quickgroceries.order.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.quickgroceries.order.model.ResponseDto;

@Document(collection ="orders")
public class Order {
	
	@Id
   private String orderId;	
	
   private ResponseDto orderDetails;
   private State orderState;
   
   
   public Order() {
	super();
	
   	}
   	public Order(String orderId, ResponseDto orderDetails, State orderState) {
   		super();
   		this.orderId = orderId;
   		this.orderDetails = orderDetails;
   		this.orderState = orderState;
      }
   	public State getOrderState() {
   			return orderState;
       }
    public void setOrderState(State orderState) {
    	this.orderState = orderState;
     }

    public String getorderId() {
	return orderId;
      }
	public void setorderId(String orderId) {
		this.orderId = orderId;
	}
	public ResponseDto getOrderDetails() {
		return orderDetails;
	}
	public void setOrderDetails(ResponseDto orderDetails) {
		this.orderDetails = orderDetails;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderDetails=" + orderDetails + ", orderState=" + orderState + "]";
	}
	
	 
	}
