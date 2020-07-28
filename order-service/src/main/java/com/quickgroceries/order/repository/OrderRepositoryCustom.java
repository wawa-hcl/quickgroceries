package com.quickgroceries.order.repository;

import java.util.List;

import com.quickgroceries.order.entity.Order;
import com.quickgroceries.order.entity.State;

public interface OrderRepositoryCustom {
	 List<Order> findByState(State state);
}
