package com.quickgroceries.order.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestHeader;

import com.quickgroceries.order.entity.Order;
import com.quickgroceries.order.entity.State;
import com.quickgroceries.order.exception.ResourceNotFoundException;
import com.quickgroceries.order.model.OrderIdDto;
import com.quickgroceries.order.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderRepository orderRepository;
	
	public Order createOrder(Order order) {
	
		return orderRepository.save(order);
		
	}
	
	
	 public List < Order > getAllOrder() {
		 
	        return this.orderRepository.findAll();
	    }
	 
	 
   public Order getOrderById(String orderId) {
	 Optional <Order> quickgroceries =this.orderRepository.findById(orderId);
	  if(quickgroceries.isPresent()) {
		 return quickgroceries.get();
	  }
	   else {
		   throw new ResourceNotFoundException("Record not found with id: " +orderId);
	   }
   }
   
   
   
   public int updateOrder( OrderIdDto orderidDto,State state) {
	   String[] ids = orderidDto.getOrderIds();
	   for (String i : ids) {
       Optional<Order> order = orderRepository.findById(i);
           if (order.isPresent()) {
                  Order ord = order.get();
               ord.setOrderState(state);
              orderRepository.save(ord);

             }

        return 1;
     }

       return 0;
	}
}
       
