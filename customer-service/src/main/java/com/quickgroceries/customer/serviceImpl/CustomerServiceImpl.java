package com.quickgroceries.customer.serviceImpl;

import com.quickgroceries.customer.entity.AddressEntity;
import com.quickgroceries.customer.entity.CustomerEntity;
import com.quickgroceries.customer.entityDto.CustomerRequestDto;
import com.quickgroceries.customer.entityDto.CustomerResponseDto;
import com.quickgroceries.customer.exceptions.ResourceNotFoundException;
import com.quickgroceries.customer.repository.AddressRepository;
import com.quickgroceries.customer.repository.CustomerRepository;
import com.quickgroceries.customer.service.CustomerEntityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerEntityService {

    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    AddressRepository addressRepository;
    AddressEntity addressEntity;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public long addCustomerDetails(CustomerRequestDto customerRequestDto)
    {
        logger.info("calling addCustomerDetails in CustomerServiceImpl "+customerRequestDto);
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setFirstName(customerRequestDto.getFirstName());
        customerEntity.setLastName(customerRequestDto.getLastName());
        customerEntity.setCustomerAddress(customerEntity.getCustomerAddress());
        customerEntity.setPhoneNumber(customerRequestDto.getPhoneNumber());
        customerEntity.setCustomerPreference(customerRequestDto.getCustomerPreference());
        customerEntity.setEmail(customerRequestDto.getEmail());
        customerEntity.setUserName(customerRequestDto.getUserName());
        customerEntity.setCustomerAddress(customerRequestDto.getCustomerAddress());
        customerEntity.setCustomerAddress(customerEntity.getCustomerAddress());

        customerRepository.save(customerEntity);
        logger.info("customerRequestDto saved in DB "+customerEntity);
        return customerEntity.getUidpk();
    }

    public CustomerResponseDto getCustomerDetails(long uidpk) throws ResourceNotFoundException {
        logger.info("calling getCustomerDetails in CustomerServiceImpl");
        CustomerResponseDto customerResponseDto = new CustomerResponseDto();
        Optional<CustomerEntity> customerDetail = customerRepository.findById(uidpk);
        if (customerDetail.isPresent()){
            CustomerEntity customer = customerDetail.get();
            customerResponseDto.setFirstName(customer.getFirstName());
            customerResponseDto.setLastName(customer.getLastName());
            customerResponseDto.setPhoneNumber(customer.getPhoneNumber());
            customerResponseDto.setCustomerPreference(customer.getCustomerPreference());
            customerResponseDto.setEmail(customer.getEmail());
            customerResponseDto.setUserName(customer.getUserName());
            customerResponseDto.setCustomerAddress(customer.getCustomerAddress());
            return customerResponseDto;
        }
        throw new ResourceNotFoundException("CustomerId is invalid "+ uidpk);

    }

    public CustomerEntity updateCustomerDetails(long uidpk,CustomerEntity customerEntity) throws ResourceNotFoundException {
        logger.info("calling updateCustomerDetails in CustomerServiceImpl");
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
