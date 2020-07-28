package com.quickgroceries.order.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cloud.netflix.ribbon.RibbonAutoConfiguration;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.cloud.openfeign.ribbon.FeignRibbonClientAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.quickgroceries.order.entity.Order;
import com.quickgroceries.order.entity.State;
import com.quickgroceries.order.model.CartItemsDto;
import com.quickgroceries.order.model.OrderIdDto;
import com.quickgroceries.order.model.ResponseDto;
import com.quickgroceries.order.service.OrderService;


@ImportAutoConfiguration({RibbonAutoConfiguration.class, FeignRibbonClientAutoConfiguration.class, FeignAutoConfiguration.class})
@RunWith(SpringRunner.class)
@WebMvcTest(OrderController.class)
class OrderControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@MockBean
   OrderService orderService;
	

	
	@Test
	public void testCreateOrder() throws Exception {
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
	
	     
	     
		String inputInJson = this.mapToJson(mockOrder);

		String URI = "quickgroceries/api/order/fetch";
		

		Mockito.when(orderService.createOrder(Mockito.any(Order.class))).thenReturn(mockOrder);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				URI).content(inputInJson).accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();

		String outputInJson = response.getContentAsString();
        assertThat(outputInJson).isEqualTo(inputInJson);
	    assertEquals(HttpStatus.NO_CONTENT.value(), response.getStatus());
	    
				
				
	 }
	
	
       @Test
	   public void testgetOrderById() throws Exception {
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
   		Mockito.when(orderService.getOrderById(Mockito.anyString())).thenReturn(mockOrder);
   		
   		String URI = "quickgroceries/api/order/5f183d89636166f0";
   		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				URI).accept(
				MediaType.APPLICATION_JSON);
   		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String expectedJson = this.mapToJson(mockOrder);
		String outputInJson = result.getResponse().getContentAsString();
		assertThat(outputInJson).isEqualTo(expectedJson);
	   }
       
       
       @Test
       public void testgetAllOrderBystate() throws Exception {
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
    		Mockito.when(orderService.getAllOrder(State.READYFORFULLFILLMENT)).thenReturn(orderList);
    		
    		String URI = "quickgroceries/api//order";
    		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
    				URI).accept(
    				MediaType.APPLICATION_JSON);

    		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

    		String expectedJson = this.mapToJson(  orderList);
    		String outputInJson = result.getResponse().getContentAsString();
    		assertThat(outputInJson).isEqualTo(expectedJson);
      		
       }
       
       
	private String mapToJson(List<Order> orderList) throws JsonProcessingException{
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(orderList);
		
	}

	@Test
	public void updateOrderState() throws Exception {
		com.quickgroceries.order.entity.State state=com.quickgroceries.order.entity.State.READYFORDELIVERY;
        OrderIdDto orderIdDto=new OrderIdDto();
         String orderid[]= {"76dhk89636166f0","5f183d89636166f0"};

		 orderIdDto.setOrderIds(orderid);
         Mockito.when(orderService.updateOrderByIds(orderIdDto, state)).thenReturn(1);
         String URI = "/quickgroceries/api/order";
         RequestBuilder requestBuilder = MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON);
         MvcResult result = mockMvc.perform(requestBuilder).andReturn();
         MockHttpServletResponse response = result.getResponse();
         String outputInJson = response.getContentAsString();
         assertThat(outputInJson).isEqualTo(1);
         assertEquals(HttpStatus.NO_CONTENT.value(), response.getStatus());

		 }

	private String mapToJson(Order mockOrder) throws JsonProcessingException{
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(mockOrder);
	}
}


