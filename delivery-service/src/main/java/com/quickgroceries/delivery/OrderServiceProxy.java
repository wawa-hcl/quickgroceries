package com.quickgroceries.delivery;

import java.util.List;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import com.quickgroceries.delivery.model.Order;
import com.quickgroceries.delivery.model.State;





@FeignClient(name="api-gateway-server")
public interface OrderServiceProxy {
	@GetMapping("/order-service/quickgroceries/api/order")
	public  List < Order > getAllOrderBystate(@RequestHeader(value = "STATE", required = true) State state);
	
	
	@PutMapping("/order-service/quickgroceries/api/order")
	public   HttpStatus updateOrderState( @RequestBody String orderIds[], @RequestHeader(value = "STATE", required = true) State state); 
}
