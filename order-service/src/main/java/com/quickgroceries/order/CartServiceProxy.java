package com.quickgroceries.order;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.quickgroceries.order.entity.Order;
import com.quickgroceries.order.entity.State;
import com.quickgroceries.order.model.ResponseDto;
import com.quickgroceries.order.service.OrderService;

@FeignClient(name="api-gateway-server")
public interface CartServiceProxy {
 
	@GetMapping("/cart-service/quickgroceries/api/cart")
	 public List<ResponseDto> getCartByState(
@RequestHeader(value = "STATE", required = true) State stateValue);
	
	@PutMapping("/cart-service/quickgroceries/api/cart")
	public HttpStatus updateCartState(@RequestHeader(value = "STATE", required = true) State stateValue,
 @RequestBody long[] cartIds);
		
	
	
}
