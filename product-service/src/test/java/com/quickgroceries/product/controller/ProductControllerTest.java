package com.quickgroceries.product.controller;



import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.quickgroceries.product.model.ListPrice;
import com.quickgroceries.product.model.ResponseDto;
import com.quickgroceries.product.service.ProductService;


@ExtendWith(SpringExtension.class)
@WebMvcTest(value=ProductController.class)
@WithMockUser
class ProductControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	ProductService productService;

	
	//String exampleProductJson= "{\"id\":\"1\",\"productName\":\"Natraj Pencil\",\"productDescription\":\"HB pencil lead\",\"productShortName\":\"NP\",\"listprice\":[\"amount\":\"10.0\",\"currency\":\"INR\"]}";


	@Test
	public void retrieveDetailsForCoursePerId() throws Exception{
		
		ResponseDto mockProduct=new ResponseDto(1l,"Natraj Pencil","HB pencil lead","NP",new ListPrice(10.0,"INR"));

		Mockito.when(productService.getProductById(Mockito.anyLong())).thenReturn(mockProduct);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("quickgroceries/api/products/1").accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		System.out.println(result.getResponse());
		//String expected = "{"id":1,"productName":"Natraj Pencil","productDescription":"HB pencil lead","listprice":["amount":10.0,"currency":"INR"}";
		
		String expected = "{\n" + 
				"    \"id\": 1,\n" + 
				"    \"productName\": \"Natraj Pencil\",\n" + 
				"    \"productDescription\": \"HB pencil lead\",\n" + 
				"    \"productShortName\": \"NP\",\n" + 
				"    \"listprice\": {\n" + 
				"        \"amount\": 10.0,\n" + 
				"        \"currency\": \"INR\"\n" + 
				"    }\n" + 
				"}";
		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), true);
	}
}
