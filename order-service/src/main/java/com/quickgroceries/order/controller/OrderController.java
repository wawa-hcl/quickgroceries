package com.quickgroceries.order.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quickgroceries.order.CartServiceProxy;

import com.quickgroceries.order.CustomerServiceProxy;
import com.quickgroceries.order.entity.Customer;
import com.quickgroceries.order.entity.Order;
import com.quickgroceries.order.entity.State;
import com.quickgroceries.order.model.CustomerResponseDto;
import com.quickgroceries.order.model.OrderIdDto;
import com.quickgroceries.order.model.ResponseDto;
import com.quickgroceries.order.service.OrderService;
import com.sun.net.httpserver.Headers;

@RestController
@RequestMapping("quickgroceries/api")
public class OrderController {
	@Autowired
	private CartServiceProxy cartProxy;
	@Autowired 
	private OrderService orderService;
	
	Order od;
	Customer cust;
	
	@Autowired    
	private CustomerServiceProxy customerProxy;
 
	
    @PostMapping("/order/fetch")
	public ResponseEntity <Order>createOrder(){
			List<ResponseDto>getCartEntity= cartProxy.getCartByState(State.READY);
		
	
			for(ResponseDto odr: getCartEntity) {
				od.setorderId(UUID.randomUUID().toString());
				od.setOrderDetails(odr);
				orderService.createOrder(od);
			}
			

			
			List<ResponseDto> cartList = getCartEntity;
			long[] cartIds = new long[cartList.size()];
		if(null != cartList && cartList.size()>0) {
			for(int i=0; i<cartList.size() ;i++) {
				cartIds[i] = cartList.get(i).getCartID();
				
			}
		}
			
			cartProxy.updateCartState(State.OPEN, cartIds);
			Long id = cust.getUidpk();
			CustomerResponseDto cusotmerDetail = customerProxy.getCustomerDetail( id);
			
			 
			 for(int i=0; i<getCartEntity.size();i++) {
				if(getCartEntity.get(i).getCart_amount()<cusotmerDetail.getWalletdetails().getAmount()){ 
					od.setOrderState(State.READYforFulfillement);
				}
					else 
			            od.setOrderState(State.Failed);
					}
		
			  return new ResponseEntity<> ( HttpStatus.NO_CONTENT);
	
		
		}
		
@GetMapping("/order/{orderId}")
public ResponseEntity<Order> getOrderById(@PathVariable String orderId){
	return ResponseEntity.ok().body(orderService.getOrderById(orderId));
}

@GetMapping("/order")
public ResponseEntity < List < Order >> getAllOrderBystate(@RequestHeader(value = "STATE", required = true) State state) {
    System.out.println("state name..."+state.name());
    if(state.name().equalsIgnoreCase("READYforFulfillement"))
    return ResponseEntity.ok().body(orderService.getAllOrder());
    else
    {
    	
    	List <Order> o = new ArrayList<>();
    	return ResponseEntity.badRequest().body(o);
    }
    	
    	
    
}



@PutMapping("/order")
public ResponseEntity < HttpStatus > updateOrderState( @RequestBody OrderIdDto orderidDto, @RequestHeader(value = "STATE", required = true) State state) {

	int i=orderService.updateOrder(orderidDto, state);
	if (i == 1) {
    return  new ResponseEntity<> ( HttpStatus.NO_CONTENT);
}
	return new ResponseEntity<>(HttpStatus.NOT_FOUND);

}

}
