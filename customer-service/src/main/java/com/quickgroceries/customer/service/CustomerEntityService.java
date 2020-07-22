package com.quickgroceries.customer.service;
import com.quickgroceries.customer.entityDto.CustomerRequestDto;
import com.quickgroceries.customer.entityDto.CustomerResponseDto;
import com.quickgroceries.customer.entity.CustomerEntity;
import com.quickgroceries.customer.exceptions.ResourceNotFoundException;


public interface CustomerEntityService {


	public long addCustomerDetails(CustomerRequestDto customerRequestDto);
	public CustomerResponseDto getCustomerDetails(long uidpk) throws ResourceNotFoundException;
	public CustomerEntity updateCustomerDetails(long uidpk,CustomerEntity customerEntity) throws ResourceNotFoundException;
}

