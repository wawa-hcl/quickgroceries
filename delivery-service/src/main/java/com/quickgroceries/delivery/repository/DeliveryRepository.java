package com.quickgroceries.delivery.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.quickgroceries.delivery.entity.Delivery;

public interface  DeliveryRepository extends MongoRepository <Delivery, String>{
	

}
