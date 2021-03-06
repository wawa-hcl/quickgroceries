package com.quickgroceries.product.controller;

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
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.quickgroceries.product.entity.Product;
import com.quickgroceries.product.model.ListPrice;
import com.quickgroceries.product.model.RequestDto;
import com.quickgroceries.product.model.ResponseDto;
import com.quickgroceries.product.service.ProductService;

@RunWith(SpringRunner.class)
@WebMvcTest(ProductController.class)
class ProductControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	ProductService productService;

	private String mapToJson(Object object) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(object);
	}

	@Test
	void testAddProduct() throws Exception {

		RequestDto mockDto = new RequestDto();
		ListPrice mockPrice = new ListPrice();
		mockDto.setProductName("Natraj Pencil");
		mockDto.setProductDescription("HB pencil lead");
		mockDto.setProductShortName("NP");
		mockPrice.setAmount(10.0);
		mockPrice.setCurrency("INR");
		mockDto.setListPrice(mockPrice);

		Product mockProduct = new Product();
		mockProduct.setUidpk(1l);
		mockProduct.setProductName("Natraj Pencil");
		mockProduct.setProductDescription("HB pencil lead");
		mockProduct.setProductShortName("NP");
		mockProduct.setListPriceAmt(10.0);
		mockProduct.setCurrency("INR");

		String inputInJson = this.mapToJson(mockDto);

		String URI = "/quickgroceries/api/products";

		Mockito.when(productService.addService(Mockito.any(RequestDto.class))).thenReturn(1l);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(URI).accept(MediaType.APPLICATION_JSON)
				.content(inputInJson).contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();

		String outputInJson = response.getContentAsString();

		assertThat(outputInJson).isEqualTo(mockProduct.getUidpk());
		assertEquals(HttpStatus.CREATED.value(), response.getStatus());

	}

	@Test
	public void testGetProductById() throws Exception {
		ResponseDto mockResponse = new ResponseDto();
		mockResponse.setId(1l);
		mockResponse.setProductName("Natraj Pencil");
		mockResponse.setProductDescription("HB pencil lead");
		mockResponse.setProductShortName("NP");
		ListPrice mockPrice = new ListPrice();
		mockPrice.setAmount(10.0);
		mockPrice.setCurrency("INR");
		mockResponse.setListprice(mockPrice);

		Mockito.when(productService.getProductById(Mockito.anyLong())).thenReturn(mockResponse);

		String URI = "/quickgroceries/api/products/1";

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		String expectedJson = this.mapToJson(mockResponse);
		String outputInJson = result.getResponse().getContentAsString();
		assertThat(outputInJson).isEqualTo(expectedJson);
	}

	@Test
	public void testGetProducts() throws Exception {

		ResponseDto mockResponse = new ResponseDto();
		mockResponse.setId(1l);
		mockResponse.setProductName("Natraj Pencil");
		mockResponse.setProductDescription("HB pencil lead");
		mockResponse.setProductShortName("NP");
		ListPrice mockPrice = new ListPrice();
		mockPrice.setAmount(10.0);
		mockPrice.setCurrency("INR");
		mockResponse.setListprice(mockPrice);

		ResponseDto mockResponse1 = new ResponseDto();
		mockResponse1.setId(2l);
		mockResponse1.setProductName("Pen");
		mockResponse1.setProductDescription("Parker Pen");
		mockResponse1.setProductShortName("P1");
		ListPrice mockPrice1 = new ListPrice();
		mockPrice1.setAmount(100.0);
		mockPrice1.setCurrency("INR");
		mockResponse1.setListprice(mockPrice1);

		List<ResponseDto> list = new ArrayList<>();
		list.add(mockResponse);
		list.add(mockResponse1);

		Mockito.when(productService.getAllProducts()).thenReturn(list);

		String URI = "/quickgroceries/api/products";

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		String expectedJson = this.mapToJson(list);
		String outputInJson = result.getResponse().getContentAsString();
		assertThat(outputInJson).isEqualTo(expectedJson);

	}

}
