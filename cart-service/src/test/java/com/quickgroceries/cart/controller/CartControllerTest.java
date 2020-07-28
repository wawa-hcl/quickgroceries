package com.quickgroceries.cart.controller;



import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
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

import com.quickgroceries.cart.model.Action;

import com.quickgroceries.cart.model.CartIdDto;
import com.quickgroceries.cart.model.CartItemsDto;
import com.quickgroceries.cart.model.RequestDto;
import com.quickgroceries.cart.model.ResponseDto;
import com.quickgroceries.cart.model.StateCartResponseDto;
import com.quickgroceries.cart.service.CartService;




@RunWith(SpringRunner.class)
@WebMvcTest(CartController.class)
class CartControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	CartService cartService;
	
	private String mapToJson(Object object) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(object);
	}

	@Test
	void testAlterItemsInCart() throws Exception{
		RequestDto mockDto = new RequestDto();
		mockDto.setProduct_id(1l);
		mockDto.setQuantity(2);
		mockDto.setAction(Action.ADD);
		
		String inputInJson = this.mapToJson(mockDto);
		
		Mockito.when(cartService.addCartAndItemsBycustomerUid(Mockito.anyLong(),Mockito.any(RequestDto.class))).thenReturn(1);

		String URI ="/quickgroceries/api/cart/customer/1";
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(URI).accept(MediaType.APPLICATION_JSON)
				.content(inputInJson).contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();

		String outputInJson = response.getContentAsString();
		assertThat(outputInJson).isEqualTo(1);
		assertEquals(HttpStatus.CREATED.value(), response.getStatus());
		
	}
	
	@Test
	void testUpdateItemsInCart() throws Exception{
		RequestDto mockDto = new RequestDto();
		mockDto.setProduct_id(1l);
		mockDto.setQuantity(2);
		mockDto.setAction(Action.UPDATE);
		
		String inputInJson = this.mapToJson(mockDto);
		Mockito.when(cartService.updateCartAndItemsBycustomerUid(Mockito.anyLong(),Mockito.any(RequestDto.class))).thenReturn(1);

		String URI ="/quickgroceries/api/cart/customer/1";
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(URI).accept(MediaType.APPLICATION_JSON)
				.content(inputInJson).contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		
		String outputInJson = response.getContentAsString();
		assertThat(outputInJson).isEqualTo(1);
		assertEquals(HttpStatus.CREATED.value(), response.getStatus());
		
	}
	
	@Test
	void testClearCartIems() throws Exception{
		
		Mockito.when(cartService.clearCartIemsByCustomerId(Mockito.anyLong())).thenReturn(1);
		
		String URI ="/quickgroceries/api/cart/customer/1";
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		//String outputInJson = result.getResponse().getContentAsString();
		assertThat(result.getResponse().getStatus()).isEqualTo(HttpStatus.OK);
	}
	
	@Test
	void testGetCustomerCart() throws Exception{
		
		List<CartItemsDto> list=new ArrayList<CartItemsDto>();
		ResponseDto mockResponse=new ResponseDto();
		CartItemsDto cartItemsDto=new CartItemsDto();
		mockResponse.setCart_amount(2200.0);
		cartItemsDto.setProductID(1l);
		cartItemsDto.setQuantity(2);
		list.add(cartItemsDto);
		mockResponse.setCartItems(list);
		
		Mockito.when(cartService.getCustomerCartByCustomerId(Mockito.anyLong())).thenReturn(mockResponse);
		String URI ="/quickgroceries/api/cart/customer/1";
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		String expectedJson = this.mapToJson(mockResponse);
		String outputInJson = result.getResponse().getContentAsString();
		assertThat(outputInJson).isEqualTo(expectedJson);
		
	}
	
	@Test
	void testGetCartByState() throws Exception{
		
		com.quickgroceries.cart.entity.State stateValue=com.quickgroceries.cart.entity.State.READY;
		
		List<StateCartResponseDto> l=new ArrayList<StateCartResponseDto>();
		StateCartResponseDto StateCartResponseDto=new StateCartResponseDto();
		List<CartItemsDto> list=new ArrayList<CartItemsDto>();
		StateCartResponseDto.setCartID(1l);
		StateCartResponseDto.setCustomerID(11l);
		StateCartResponseDto.setCart_amount(1200.0);
		CartItemsDto cartItemsDto=new CartItemsDto();
		cartItemsDto.setProductID(1l);
		cartItemsDto.setQuantity(2);
		
		CartItemsDto cartItemsDto1=new CartItemsDto();
		cartItemsDto1.setProductID(3l);
		cartItemsDto1.setQuantity(1);
		
		list.add(cartItemsDto);
		list.add(cartItemsDto1);
		StateCartResponseDto.setCartItems(list);
		
		
		StateCartResponseDto StateCartResponseDto1=new StateCartResponseDto();
		List<CartItemsDto> list1=new ArrayList<CartItemsDto>();
		StateCartResponseDto1.setCartID(1l);
		StateCartResponseDto1.setCustomerID(11l);
		StateCartResponseDto1.setCart_amount(1200.0);
		CartItemsDto cartItemsDto2=new CartItemsDto();
		cartItemsDto2.setProductID(1l);
		cartItemsDto2.setQuantity(2);
		
		CartItemsDto cartItemsDto3=new CartItemsDto();
		cartItemsDto3.setProductID(3l);
		cartItemsDto3.setQuantity(1);
		
		list1.add(cartItemsDto2);
		list1.add(cartItemsDto3);
		StateCartResponseDto.setCartItems(list1);
		
		l.add(StateCartResponseDto);
		l.add(StateCartResponseDto1);
		
		Mockito.when(cartService.getCartByState(stateValue)).thenReturn(l);
		
		String URI = "/quickgroceries/api/cart";
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		String expectedJson = this.mapToJson(l);
		String outputInJson = result.getResponse().getContentAsString();
		assertThat(outputInJson).isEqualTo(expectedJson);
		
	}
	
	@Test
	void testUpdateCartState() throws Exception{
		com.quickgroceries.cart.entity.State stateValue=com.quickgroceries.cart.entity.State.READY;
		
		CartIdDto cartIdDto=new CartIdDto();
		Long cartid[]= {1l,2l};
		cartIdDto.setCartIds(cartid);
		
		Mockito.when(cartService.updateCartStateByIds(stateValue, cartIdDto)).thenReturn(1);
		
		String URI = "/quickgroceries/api/cart";
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		
		String outputInJson = response.getContentAsString();
		
		assertThat(outputInJson).isEqualTo(1);
		assertEquals(HttpStatus.NO_CONTENT.value(), response.getStatus());
		
	}

}
