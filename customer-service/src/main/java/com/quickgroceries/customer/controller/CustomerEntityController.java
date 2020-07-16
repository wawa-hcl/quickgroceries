package com.quickgroceries.customer.controller;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

import javax.validation.Valid;

import org.hibernate.mapping.Array;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.quickgroceries.customer.CallWalletService;
import com.quickgroceries.customer.entity.CustomerEntity;
import com.quickgroceries.customer.exceptions.ResourceNotFoundException;
import com.quickgroceries.customer.service.CustomerEntityService;
import com.quickgroceries.wallet.entity.WalletEntity;

import antlr.collections.List;

@RestController
public class CustomerEntityController {
    
	@Autowired
	CustomerEntityService customerEntityService;
	
	@Autowired
	CallWalletService callWalletService;

	@PostMapping(value ="/customers",produces = "application/json")
	public ResponseEntity<Object>addCustomerDetails (@Valid @RequestBody CustomerEntity customerEntity){	
	    customerEntityService.addCustomerDetails(customerEntity); 
	  int customerPrimaryKey = customerEntity.getUidpk();
	return new ResponseEntity<>("customer Id : "+customerPrimaryKey,HttpStatus.CREATED);
	}
	
	@GetMapping("/customers/{uidpk}")
	public ResponseEntity<Object> getCustomerDetail(@PathVariable int uidpk)throws ResourceNotFoundException{
	CustomerEntity getCustomer = customerEntityService.getCustomerDetails(uidpk).orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + uidpk));
	
	return new ResponseEntity<>(getCustomer,HttpStatus.OK);
	}
	
	@PutMapping("/customers/{uidpk}")
	  public ResponseEntity<Object> updateCustomerDetail
	  (@PathVariable(value = "uidpk") int uidpk, @Valid @RequestBody CustomerEntity customerEntity)
	    throws ResourceNotFoundException {
		CustomerEntity updatedCustomerDetails = customerEntityService.updateCustomerDetails(uidpk, customerEntity);
			return new ResponseEntity<>(updatedCustomerDetails,HttpStatus.CREATED);
	
	}
	
	@GetMapping("/customers/wallet/{uidpk}")
	public ResponseEntity<Object> callWalletById(@PathVariable("uidpk") int uidpk) throws ResourceNotFoundException{
		Optional<CustomerEntity> getCustomer = customerEntityService.getCustomerDetails(uidpk);
		Object aaa = customerEntityService.getCustomerDetails(uidpk);
		java.util.List<Object> list = Arrays.asList(aaa,getCustomer);
		 	
	      return new ResponseEntity<Object>(list, HttpStatus.OK);
}
	
}

