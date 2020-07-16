package com.quickgroceries.customer.controllerTest;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.quickgroceries.customer.controller.CustomerEntityController;
import com.quickgroceries.customer.service.CustomerEntityService;

@RunWith(MockitoJUnitRunner.class)
public class CustomerEntityServiceTest {
	
	private MockMvc mockMvc;
	
	@Mock
    private CustomerEntityService customerEntityService;
	
	@InjectMocks
	private CustomerEntityController customerEntityController;
	
	@Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(customerEntityService)
                .build();
    }
	
	@Test
	public void testPostCustomer() throws Exception {
		
		String dummyCustomerDetail = "{\n" +
                "  \"uidpk\": \"\",\n" +
                "  \"firstName\": \"Chinmay\"\n" +
                "  \"lastName\": \"Shrivastava\"\n" +
                "  \"phoneNumber\": \"909814441\"\n" +
                "  \"customerPreference\": \"veg\"\n" +
                "  \"email\": \"chinmay@hcl\"\n" +
                "  \"userName\": \"chinmay\"\n" +
                "}";
		
		mockMvc.perform(post("/customers").content(dummyCustomerDetail)
				.contentType(MediaType.APPLICATION_JSON))
		        .andExpect(status().isCreated())
		        .andExpect(jsonPath("$.firstName", Matchers.is("Chinmay")))
		        .andExpect(jsonPath("$.lastName", Matchers.is("Shrivastava")))
		        .andExpect(jsonPath("$.phoneNumber", Matchers.is("909814441")))
		        .andExpect(jsonPath("$.customerPreference", Matchers.is("veg")))
		        .andExpect(jsonPath("$.email", Matchers.is("chinmay@hcl")))
		        .andExpect(jsonPath("$.userName", Matchers.is("chinmay")))
		        .andExpect(jsonPath("$.*", Matchers.hasSize(6)));
		
	
	}

}

	
	
	
	


