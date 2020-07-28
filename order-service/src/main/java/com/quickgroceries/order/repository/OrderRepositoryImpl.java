package com.quickgroceries.order.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.quickgroceries.order.entity.Order;
import com.quickgroceries.order.entity.State;

public class OrderRepositoryImpl implements OrderRepositoryCustom {
	private final MongoOperations operations;

	  @Autowired
	  public OrderRepositoryImpl(MongoOperations operations) {
	    this.operations = operations;
	  }

	public List<Order> findByState(State state) {
		 Query searchQuery = new Query();
		 searchQuery.addCriteria(Criteria.where("state").is(state.toString()));
		 List<Order> order = operations.find(searchQuery, Order.class);
		 return order;
		
	}

}
