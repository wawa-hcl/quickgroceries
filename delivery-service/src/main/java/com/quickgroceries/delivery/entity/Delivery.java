package com.quickgroceries.delivery.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.quickgroceries.delivery.model.Order;

@Document(collection ="deliveries")
public class Delivery {
	@Id
	private String deliveryId;
	private Order deliveryDetails;
	public String getDeliveryId() {
		return deliveryId;
	}
	public void setDeliveryId(String deliveryId) {
		this.deliveryId = deliveryId;
	}
	public Order getDeliveryDetails() {
		return deliveryDetails;
	}
	public void setDeliveryDetails(Order deliveryDetails) {
		this.deliveryDetails = deliveryDetails;
	}
	
	
	
	
}
