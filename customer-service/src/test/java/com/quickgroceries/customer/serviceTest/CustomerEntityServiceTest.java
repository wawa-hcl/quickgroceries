package com.quickgroceries.customer.serviceTest;

import static org.assertj.core.api.Assertions.assertThat;
import com.quickgroceries.customer.entity.AddressEntity;
import com.quickgroceries.customer.entity.CustomerEntity;
import com.quickgroceries.customer.entityDto.CustomerRequestDto;
import com.quickgroceries.customer.entityDto.CustomerResponseDto;
import com.quickgroceries.customer.exceptions.ResourceNotFoundException;
import com.quickgroceries.customer.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.quickgroceries.customer.service.CustomerEntityService;
import com.quickgroceries.customer.serviceImpl.CustomerServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerEntityServiceTest {

	@Mock
	CustomerRepository customerRepository;
	@InjectMocks
	CustomerServiceImpl customerService;

	@BeforeEach
	public void setUp(){
		MockitoAnnotations.initMocks(this);
	}
	@Test
   public void addCustomerDetailsTest(){

	   CustomerRequestDto customerRequestDto = new CustomerRequestDto();
	   customerRequestDto.setFirstName("Chinmay");
	   customerRequestDto.setLastName("Shrivastava");
	   customerRequestDto.setPhoneNumber(909814491);
	   customerRequestDto.setCustomerPreference("VEG");
	   customerRequestDto.setEmail("chinmay@hcl.com");
	   customerRequestDto.setUserName("Chinmay");
	   AddressEntity addressEntity = new AddressEntity();
	   addressEntity.setLocality("Krishna Nagar");
	   addressEntity.setStreetAddress("C-!06");
	   addressEntity.setCity("Gwalior");
	   addressEntity.setState("Madhya Pradesh");
	   addressEntity.setCountry("India");

	   CustomerEntity customerEntity = new CustomerEntity();
	   customerEntity.setUidpk(23);
	   customerEntity.setFirstName(customerRequestDto.getFirstName());
	   customerEntity.setLastName(customerRequestDto.getLastName());
	   customerEntity.setCustomerPreference(customerRequestDto.getCustomerPreference());
	   customerEntity.setPhoneNumber(customerRequestDto.getPhoneNumber());
	   customerEntity.setEmail(customerRequestDto.getEmail());
	   customerEntity.setUserName(customerRequestDto.getUserName());
	   customerRequestDto.setCustomerAddress(addressEntity);
	   Mockito.when(customerRepository.save(customerEntity)).thenReturn(customerEntity);
	   assertThat(customerRepository.save(customerEntity)).isEqualTo(customerEntity);

   }
	/*
	 * @Test public void testGetCustomerDetailById(){ CustomerResponseDto
	 * customerResponseDto = new CustomerResponseDto();
	 * customerResponseDto.setFirstName("Chinmay");
	 * customerResponseDto.setLastName("Shrivastava");
	 * customerResponseDto.setPhoneNumber(9098144);
	 * customerResponseDto.setCustomerPreference("VEG");
	 * customerResponseDto.setEmail("chinmay@hcl.com");
	 * customerResponseDto.setUserName("Chinmay");
	 * 
	 * CustomerEntity customerEntity = new CustomerEntity();
	 * customerEntity.setUidpk(23);
	 * customerEntity.setFirstName(customerResponseDto.getFirstName());
	 * customerEntity.setLastName(customerResponseDto.getLastName());
	 * customerEntity.setCustomerPreference(customerResponseDto.
	 * getCustomerPreference());
	 * customerEntity.setPhoneNumber(customerResponseDto.getPhoneNumber());
	 * customerEntity.setEmail(customerResponseDto.getEmail());
	 * customerEntity.setUserName(customerResponseDto.getUserName()); AddressEntity
	 * addressEntity = new AddressEntity();
	 * addressEntity.setLocality("Krishna Nagar");
	 * addressEntity.setStreetAddress("C-!06"); addressEntity.setCity("Gwalior");
	 * addressEntity.setState("Madhya Pradesh"); addressEntity.setCountry("India");
	 * customerEntity.setCustomerAddress(addressEntity);
	 * 
	 * Mockito.when(customerRepository.findById(customerEntity.getUidpk())).
	 * thenReturn(java.util.Optional.of(customerEntity));
	 * assertThat(customerRepository.findById(23l)).isEqualTo(customerEntity); }
	 * public void testGetCustomerDetailByInvalidId() throws
	 * ResourceNotFoundException {
	 * 
	 * CustomerResponseDto customerResponseDto = new CustomerResponseDto();
	 * customerResponseDto.setFirstName("Chinmay");
	 * customerResponseDto.setLastName("Shrivastava");
	 * customerResponseDto.setPhoneNumber(909814491);
	 * customerResponseDto.setCustomerPreference("VEG");
	 * customerResponseDto.setEmail("chinmay@hcl.com");
	 * customerResponseDto.setUserName("Chinmay");
	 * 
	 * CustomerEntity customerEntity = new CustomerEntity();
	 * customerEntity.setUidpk(23);
	 * customerEntity.setFirstName(customerResponseDto.getFirstName());
	 * customerEntity.setLastName(customerResponseDto.getLastName());
	 * customerEntity.setCustomerPreference(customerResponseDto.
	 * getCustomerPreference());
	 * customerEntity.setPhoneNumber(customerResponseDto.getPhoneNumber());
	 * customerEntity.setEmail(customerResponseDto.getEmail());
	 * customerEntity.setUserName(customerResponseDto.getUserName()); AddressEntity
	 * addressEntity = new AddressEntity();
	 * addressEntity.setLocality("Krishna Nagar");
	 * addressEntity.setStreetAddress("C-!06"); addressEntity.setCity("Gwalior");
	 * addressEntity.setState("Madhya Pradesh"); addressEntity.setCountry("India");
	 * //Mockito.when(customerRepository.findById(6834l)).thenReturn(throw new
	 * ResourceNotFoundException("CustomerId is invalid "+customerEntity.getUidpk())
	 * ); assertThat(customerRepository.findById(6834l)).isEqualTo(new
	 * ResourceNotFoundException("CustomerId is invalid "+customerEntity.getUidpk())
	 * );
	 * 
	 * }
	 */
 /* public void testUpdateCustomerDetails(){
	  CustomerEntity customerEntity = new CustomerEntity();
	  customerRepository.findById(uidpk);
	  customerEntity.setFirstName(customerEntity.getFirstName());
	  customerEntity.setLastName(customerEntity.getLastName());
	  customerEntity.setPhoneNumber(customerEntity.getPhoneNumber());
	  customerEntity.setCustomerPreference(customerEntity.getCustomerPreference());
	  customerEntity.setEmail(customerEntity.getEmail());
	  customerEntity.setUserName(customerEntity.getUserName());
	  customerEntity.setCustomerAddress(customerEntity.getCustomerAddress());
  }*/


}

	
	
	
	


