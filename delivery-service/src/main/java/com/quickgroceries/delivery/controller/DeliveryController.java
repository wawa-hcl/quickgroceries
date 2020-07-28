package com.quickgroceries.delivery.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
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
	  
	
	@PostMapping("/delivery/fetch")
	public ResponseEntity <HttpStatus> createDelivery(){
		List < Order> orderList =orderProxy.getAllOrderBystate(State.READYFORFULLFILLMENT);
		String [] orderIds= new String[orderList.size()];
		for(Order del: orderList) {
             for(int i=0; i<orderList.size() ;i++) {
			orderIds[i] = del.getOrderId();
				}
             Delivery delivery = new Delivery();
			delivery.setDeliveryId(UUID.randomUUID().toString());
			
			delivery.setDeliveryDetails(del);
			deliveryService.createDelivery(delivery);
		}
		
			orderProxy.updateOrderState(orderIds, State.READYFORDELIVERY);
			return new ResponseEntity<> ( HttpStatus.NO_CONTENT);
	}

}