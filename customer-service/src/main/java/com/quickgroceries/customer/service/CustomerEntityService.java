package com.quickgroceries.customer.service;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quickgroceries.customer.entity.AddressEntity;
import com.quickgroceries.customer.entity.CustomerEntity;
import com.quickgroceries.customer.exceptions.ResourceNotFoundException;
import com.quickgroceries.customer.repository.AddressRepository;
import com.quickgroceries.customer.repository.CustomerRepository;
@Service
public class CustomerEntityService {

	
	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	AddressRepository addressRepository;
	AddressEntity addressEntity;
	
	 public CustomerEntity addCustomerDetails(CustomerEntity customerEntity) 
	 {
		 customerEntity.setCustomerAddress(customerEntity.getCustomerAddress()); 
		 System.out.println("check address : "+customerEntity.getCustomerAddress());
		   return customerRepository.save(customerEntity);
		}

	 
 public Optional<CustomerEntity> getCustomerDetails(int uidpk) throws ResourceNotFoundException{
	 return customerRepository.findById(uidpk);	 
 }
 
    public CustomerEntity updateCustomerDetails(int uidpk,CustomerEntity customerEntity) throws ResourceNotFoundException {
    	customerRepository.findById(uidpk);
    	customerEntity.setFirstName(customerEntity.getFirstName());
    	customerEntity.setLastName(customerEntity.getLastName());
    	customerEntity.setPhoneNumber(customerEntity.getPhoneNumber());
    	customerEntity.setCustomerPreference(customerEntity.getCustomerPreference());
    	customerEntity.setEmail(customerEntity.getEmail());
    	customerEntity.setUserName(customerEntity.getUserName());
    	customerEntity.setCustomerAddress(customerEntity.getCustomerAddress());
		return customerEntity;	
    }
}
