package com.quickgroceries.order.service;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import com.quickgroceries.order.entity.Order;
import com.quickgroceries.order.entity.State;
import com.quickgroceries.order.model.CartItemsDto;
import com.quickgroceries.order.model.OrderIdDto;
import com.quickgroceries.order.model.ResponseDto;
import com.quickgroceries.order.repository.OrderRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
class OrderServiceImplTest {
	
	@Autowired
	private OrderService orderService;

	@MockBean
	private OrderRepository orderRepository;

	@Test
	public void testCreateOrder() {
		Order mockOrder = new Order();
		ResponseDto mockResponseDto= new ResponseDto();
		CartItemsDto mockCartItemsDto= new CartItemsDto();
		List <CartItemsDto> mockCartItems= new ArrayList<>();
		mockOrder.setorderId("5f183d89636166f0");
		
		mockResponseDto.setCartID(1l);
		mockResponseDto.setCustomerID(2l);
		mockResponseDto.setCart_amount(20.45);
		mockCartItemsDto.setProductID(1l);
		mockCartItemsDto.setQuantity(10);
		mockCartItems.add(mockCartItemsDto);
		mockResponseDto.setCartItems(mockCartItems);
		mockOrder.setOrderDetails(mockResponseDto);
		mockOrder.setOrderState(State.READYFORFULLFILLMENT);
		Mockito.when(orderRepository.save(mockOrder)).thenReturn(mockOrder);

	    assertThat(orderService.createOrder(mockOrder)).isEqualTo(mockOrder);
		
	}
      
	   @Test 
	   public void testGetAllOrder() {
		   Order mockOrder1 = new Order();
     		ResponseDto mockResponseDto= new ResponseDto();
     		CartItemsDto mockCartItemsDto= new CartItemsDto();
     		List <CartItemsDto> mockCartItems= new ArrayList<>();
     		mockOrder1.setorderId("5f183d89636166f0");
     		
     		mockResponseDto.setCartID(1l);
     		mockResponseDto.setCustomerID(2l);
     		mockResponseDto.setCart_amount(20.45);
     		mockCartItemsDto.setProductID(1l);
     		mockCartItemsDto.setQuantity(10);
     		mockCartItems.add(mockCartItemsDto);
     		mockResponseDto.setCartItems(mockCartItems);
     		mockOrder1.setOrderDetails(mockResponseDto);
     		mockOrder1.setOrderState(State.READYFORFULLFILLMENT);
     		
     		Order mockOrder2 = new Order();
     		ResponseDto mockResponseDto1= new ResponseDto();
     		CartItemsDto mockCartItemsDto1= new CartItemsDto();
     		List <CartItemsDto> mockCartItems1= new ArrayList<>();
     		mockOrder1.setorderId("76dhk89636166f0");
     		
     		mockResponseDto1.setCartID(2l);
     		mockResponseDto1.setCustomerID(3l);
     		mockResponseDto1.setCart_amount(50.45);
     		mockCartItemsDto1.setProductID(2l);
     		mockCartItemsDto1.setQuantity(20);
     		mockCartItems1.add(mockCartItemsDto1);
     		mockResponseDto1.setCartItems(mockCartItems1);
     		mockOrder2.setOrderDetails(mockResponseDto1);
     		mockOrder2.setOrderState(State.READYFORFULLFILLMENT);
     		
     		List<Order> orderList = new ArrayList<>();
   		    orderList.add(mockOrder1);
   		    orderList.add(mockOrder2);
   		    Mockito.when(orderRepository.findByState(State.READYFORFULLFILLMENT)).thenReturn(orderList);
   		    assertThat(orderService.getAllOrder(State.READYFORFULLFILLMENT)).isEqualTo(orderList);
   		
		
	}
	  
	      @Test
	     public void  testGetOrderById( ) {
	    	    Order mockOrder = new Order();
	    	    ResponseDto mockResponseDto= new ResponseDto();
	     		CartItemsDto mockCartItemsDto= new CartItemsDto();
	     		List <CartItemsDto> mockCartItems= new ArrayList<>();
	     		mockOrder.setorderId("76dhk89636166f0");
	     		
	     		mockResponseDto.setCartID(1l);
	     		mockResponseDto.setCustomerID(2l);
	     		mockResponseDto.setCart_amount(20.45);
	     		mockCartItemsDto.setProductID(1l);
	     		mockCartItemsDto.setQuantity(10);
	     		mockCartItems.add(mockCartItemsDto);
	     		mockResponseDto.setCartItems(mockCartItems);
	     		mockOrder.setOrderDetails(mockResponseDto);
	     		mockOrder.setOrderState(State.READYFORFULLFILLMENT);
	     		Optional<Order> mockOrder1 = this.orderRepository.findById("76dhk89636166f0");
	     		Mockito.when(orderRepository.findById("76dhk89636166f0")).thenReturn(mockOrder1);
	    	    assertThat(orderService.getOrderById("76dhk89636166f0")).isEqualTo(mockOrder1);
		  
	     }
	      
	     @Test 
	    public void  testUpdateOrderByIds( ) {
	    	Order mockOrder = new Order();
	    	ResponseDto mockResponseDto= new ResponseDto();
	 		CartItemsDto mockCartItemsDto= new CartItemsDto();
	 		List <CartItemsDto> mockCartItems= new ArrayList<>();
	 		mockOrder.setorderId("5f183d89636166f0");
	 		
	 		mockResponseDto.setCartID(1l);
	 		mockResponseDto.setCustomerID(2l);
	 		mockResponseDto.setCart_amount(20.45);
	 		mockCartItemsDto.setProductID(1l);
	 		mockCartItemsDto.setQuantity(10);
	 		mockCartItems.add(mockCartItemsDto);
	 		mockResponseDto.setCartItems(mockCartItems);
	 		mockOrder.setOrderDetails(mockResponseDto);
	 		mockOrder.setOrderState(State.READYFORFULLFILLMENT);
	    	
	        OrderIdDto orderIdDto=new OrderIdDto();
	        String orderid[]= {"76dhk89636166f0","5f183d89636166f0"};
            orderIdDto.setOrderIds(orderid);
	 		mockOrder.setOrderState(State.READYFORDELIVERY);
	 		Mockito.when(orderRepository.save(mockOrder)).thenReturn(mockOrder);
            assertThat(orderService.updateOrderByIds( orderIdDto,State.READYFORDELIVERY)).isEqualTo(mockOrder);
			
			
	    }
	     
}
