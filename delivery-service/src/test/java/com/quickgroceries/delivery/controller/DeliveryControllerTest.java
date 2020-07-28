package com.quickgroceries.delivery.controller;

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
import com.quickgroceries.delivery.entity.Delivery;
import com.quickgroceries.delivery.model.Order;
import com.quickgroceries.delivery.service.DeliveryService;
import com.quickgroceries.delivery.model.ResponseDto;
import com.quickgroceries.delivery.model.CartItemsDto;


@ImportAutoConfiguration({RibbonAutoConfiguration.class, FeignRibbonClientAutoConfiguration.class, FeignAutoConfiguration.class})
@RunWith(SpringRunner.class)
@WebMvcTest(DeliveryController.class)
class DeliveryControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	DeliveryService deliveryService;

	@Test
    public void testCreateDelivery() throws Exception {
		Delivery mockDelivery= new Delivery();
		List<Order> mockOrder= (List<Order>) new Order();
		((Order) mockOrder).setOrderId("5f183d89636166f0");
		ResponseDto mockResponseDto=  new ResponseDto();
		CartItemsDto mockCartItemsDto= new CartItemsDto();
		List <CartItemsDto> mockCartItems= new ArrayList<>();
		mockResponseDto.setCartID(1l);
		mockResponseDto.setCustomerID(2l);
		mockResponseDto.setCart_amount(20.45);
		mockCartItemsDto.setProductID(1l);
		mockCartItemsDto.setQuantity(10);
		mockCartItems.add(mockCartItemsDto);
		mockResponseDto.setCartItems(mockCartItems);
		((Order) mockOrder).setOrderDetails(mockResponseDto);
		com.quickgroceries.delivery.model.State state=com.quickgroceries.delivery.model.State.READYFORFULLFILLMENT;
		((Order) mockOrder).setOrderState(state);
		mockDelivery.setDeliveryId("gh78549kpky");
		mockDelivery.setDeliveryDetails( (Order) mockOrder);
		String inputInJson = this.mapToJson(mockDelivery);
		String URI = "quickgroceries/api/delivery/fetch";
		Mockito.when(deliveryService.createDelivery(Mockito.any(Delivery.class))).thenReturn(mockDelivery);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				URI).content(inputInJson).accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();

		String outputInJson = response.getContentAsString();
        

		assertThat(outputInJson).isEqualTo(inputInJson);
	    assertEquals(HttpStatus.NO_CONTENT.value(), response.getStatus());
		
	
	}

	private String mapToJson(Delivery mockDelivery) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(mockDelivery);
	}

}
