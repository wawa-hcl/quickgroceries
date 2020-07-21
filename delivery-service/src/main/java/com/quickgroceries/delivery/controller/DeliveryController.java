package com.quickgroceries.delivery.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.quickgroceries.delivery.OrderServiceProxy;
import com.quickgroceries.delivery.entity.Delivery;
import com.quickgroceries.delivery.model.Order;
import com.quickgroceries.delivery.model.State;
import com.quickgroceries.delivery.service.DeliveryService;



@RestController
@RequestMapping("quickgroceries/api")
public class DeliveryController {
	@Autowired
	private OrderServiceProxy orderProxy;
	private DeliveryService deliveryService;
	  
	Delivery delivery;
	@PostMapping("/delivery/fetch")
	public ResponseEntity <Delivery> createDelivery(){
		List < Order> orderList =orderProxy.getAllOrderBystate(State.READYforFulfillement);
		
		for(Order del: orderList) {
			delivery.setDeliveryId(UUID.randomUUID().toString());
			
			delivery.setDeliveryDetails(del);
			deliveryService.createDelivery(delivery);
		}
		

		
		List<Order> deliveryList = orderList;
		String[] orderIds = new String[deliveryList.size()];
	if(null != deliveryList && deliveryList.size()>0) {
		for(int i=0; i<deliveryList.size() ;i++) {
		orderIds[i] = deliveryList.get(i).getOrderId();
			
		}
	}
		
		orderProxy.updateOrderState(orderIds, State.READYforDelivery);
		return new ResponseEntity<> ( HttpStatus.NO_CONTENT);
	}

}