package com.quickgroceries.delivery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quickgroceries.delivery.entity.Delivery;
import com.quickgroceries.delivery.repository.DeliveryRepository;

@Service
public class DeliveryServiceImpl implements DeliveryService {
	@Autowired
	private DeliveryRepository deliveryRepository;

	public Delivery createDelivery(Delivery delivery) {
	
		return deliveryRepository.save(delivery);
		
	}
}
