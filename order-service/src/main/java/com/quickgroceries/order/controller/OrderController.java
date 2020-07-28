package com.quickgroceries.order.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.quickgroceries.order.entity.Order;
import com.quickgroceries.order.entity.State;
import com.quickgroceries.order.model.CustomerResponseDto;
import com.quickgroceries.order.model.OrderIdDto;
import com.quickgroceries.order.model.ResponseDto;
import com.quickgroceries.order.service.OrderService;




@RestController
@RequestMapping("quickgroceries/api")
public class OrderController {
	
	@Autowired
	private CartServiceProxy cartProxy;
	
	@Autowired 
	private OrderService orderService;
	
	@Autowired   
	private CustomerServiceProxy customerProxy;
	
	
   @PostMapping("/order/fetch")
	public ResponseEntity <HttpStatus>createOrder(){
			List<ResponseDto>getCartEntity= cartProxy.getCartByState(State.READY);
			long [] cartIds= new long[getCartEntity.size()];
		
			for(ResponseDto odr: getCartEntity) {
			
				for(int i=0; i<getCartEntity.size() ;i++) {
			cartIds[i] = odr.getCartID();
				}
				Order od = new Order();
				od.setorderId(UUID.randomUUID().toString());
				
				
				od.setOrderDetails(odr);
				Long id = odr.getCustomerID();
				CustomerResponseDto cusotmerDetail = customerProxy.getCustomerDetail( id);
				
             if(odr.getCart_amount()<cusotmerDetail.getWalletDetails().getAmount()){ 
					
					od.setOrderState(State.READYFORFULLFILLMENT);
				}
					else 
			            od.setOrderState(State.FAILED);
					
				orderService.createOrder(od);
			}
			
             cartProxy.updateCartState(State.OPEN, cartIds);
			
			  return new ResponseEntity<> ( HttpStatus.NO_CONTENT);
	
		
		}
    
    
		
    @GetMapping("/order/{orderId}")
    public ResponseEntity<Order> getOrderById(@PathVariable("orderId") String orderId){
    			return ResponseEntity.ok().body(orderService.getOrderById(orderId));
    	}



   @GetMapping("/order")
   	public ResponseEntity < List < Order >> getAllOrderBystate(@RequestHeader(value = "STATE", required = true) State state) {
	   
	            return ResponseEntity.ok().body(orderService.getAllOrder(state));
	   		
	 	}



   	@PutMapping("/order")
   	public ResponseEntity < HttpStatus > updateOrderState( @RequestBody OrderIdDto orderidDto, @RequestHeader(value = "STATE", required = true) State state) {

   				int i=orderService.updateOrderByIds(orderidDto, state);
   				if (i == 1) {
   								return  new ResponseEntity<> ( HttpStatus.NO_CONTENT);
   							}
   						return new ResponseEntity<>(HttpStatus.NOT_FOUND);

   			}

	}
