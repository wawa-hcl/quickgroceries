/*
package com.quickgroceries.customer.controllerTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.quickgroceries.customer.controller.CustomerEntityController;
import com.quickgroceries.customer.entity.CustomerEntity;
import com.quickgroceries.customer.entityDto.CustomerResponseDto;
import com.quickgroceries.customer.service.CustomerEntityService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(value = CustomerEntityController.class)
public class CustomerEntityControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CustomerEntityService customerEntityService;
	private ObjectMapper objectMapper = new ObjectMapper();
	@InjectMocks
	CustomerEntityController customerEntityController;

	@Before
	public void setUp() throws Exception {
  	*/
/*mockMvc = MockMvcBuilders.standaloneSetup(customerEntityService)
			.build();*//*

	}
   @Test
	public void testGetCustomerDetailById() throws Exception {

		CustomerResponseDto customerResponseDto = new CustomerResponseDto();
		CustomerEntity customerEntity = new CustomerEntity();
		customerEntity.setUidpk(9);
		customerResponseDto.setFirstName("Chinmay");
		customerResponseDto.setLastName("Shrivastava");
		customerResponseDto.setEmail("chinmay@hcl.com");
		customerResponseDto.setCustomerPreference("veg");
		customerResponseDto.setPhoneNumber(909814432);
		customerResponseDto.setUserName("chinmay");
		when(customerEntityService.getCustomerDetails(anyLong())).thenReturn(customerResponseDto);
		mockMvc.perform(get("/customers/9")).andExpect(status().isOk());




	*/
/*@Test
	public void testGetCustomer() throws Exception {
		mockMvc = MockMvcBuilders.standaloneSetup(customerEntityService)
				.build();
		//ResponseEntity mockResponse = new ResponseEntity();
//		mockResponse.setFirstName("Chinmay");
//		mockResponse.setLastName("Shrivastava");
//		mockResponse.setEmail("chinmay@hcl.com");
//		mockResponse.setCustomerPreference("veg");
//		mockResponse.setPhoneNumber(909814432);
//		mockResponse.setUserName("chinmay");

		/*Mockito.when(customerEntityController.getCustomerDetailById(Mockito.anyLong()))
		.thenReturn(mockResponse);*//*


		*/
/*mockMvc.perform(get("//customers/1")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.firstName", Matchers.is("Chinmay")))
				.andExpect(jsonPath("$.lastName", Matchers.is("Shrivastava")))
				.andExpect(jsonPath("$.phoneNumber", Matchers.is("909814441")))
				.andExpect(jsonPath("$.customerPreference", Matchers.is("veg")))
				.andExpect(jsonPath("$.email", Matchers.is("chinmay@hcl")))
				.andExpect(jsonPath("$.userName", Matchers.is("chinmay")))
				.andExpect(jsonPath("$.*", Matchers.hasSize(6)));

		System.out.println("hello");

	}*//*



	}
}
	
	
	
	


*/
