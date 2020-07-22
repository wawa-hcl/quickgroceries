package com.quickgroceries.customer.controllerTest;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.quickgroceries.customer.entity.CustomerEntity;
import com.quickgroceries.customer.entityDto.CustomerRequestDto;
import com.quickgroceries.customer.entityDto.CustomerResponseDto;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.quickgroceries.customer.controller.CustomerEntityController;
import com.quickgroceries.customer.service.CustomerEntityService;
@ExtendWith(MockitoExtension.class)
public class CustomerEntityControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Mock
    private CustomerEntityService customerEntityService;
	@Mock
	CustomerResponseDto customerResponseDto;
	@Mock
	CustomerEntity customerEntity;
	@Mock
	CustomerRequestDto customerRequestDto;
	@InjectMocks
	private CustomerEntityController customerEntityController;

	@Before
	public void setUp() throws Exception {
  	/*mockMvc = MockMvcBuilders.standaloneSetup(customerEntityService)
			.build();*/
	}
	
	/*@Test
	public void testPostCustomer() throws Exception {
		mockMvc = MockMvcBuilders.standaloneSetup(customerEntityController)
				.build();
		String dummyCustomerDetail = "{\n" +
                "  \"uidpk\": \"\",\n" +
                "  \"firstName\": \"Chinmay\"\n" +
                "  \"lastName\": \"Shrivastava\"\n" +
                "  \"phoneNumber\": \"909814441\"\n" +
                "  \"customerPreference\": \"veg\"\n" +
                "  \"email\": \"chinmay@hcl\"\n" +
                "  \"userName\": \"chinmay\"\n" +
                "}";
   when(customerEntityService.addCustomerDetails(customerRequestDto)).thenReturn(Mockito.anyLong());
		mockMvc.perform(post("/customers").content(dummyCustomerDetail)
				.contentType(MediaType.APPLICATION_JSON))
		        .andExpect(status().isCreated());
		verify(customerEntityService.addCustomerDetails(customerRequestDto));
	}*/

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
		.thenReturn(mockResponse);*/

		mockMvc.perform(get("//customers/1")
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

	}*/








}

	
	
	
	


