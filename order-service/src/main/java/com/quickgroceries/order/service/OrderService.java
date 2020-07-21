package com.quickgroceries.order.service;

import java.util.List;

import com.quickgroceries.order.entity.Order;
import com.quickgroceries.order.entity.State;
import com.quickgroceries.order.model.OrderIdDto;

public interface OrderService {
 Order createOrder(Order order);
 Order getOrderById(String orderId);
 List < Order > getAllOrder();
int updateOrder(OrderIdDto orderidDto,State state);

}
