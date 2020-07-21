package com.quickgroceries.order.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.quickgroceries.order.entity.Order;

public interface OrderRepository extends MongoRepository < Order, String> {

}
