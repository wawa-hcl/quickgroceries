package com.quickgroceries.customer.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.quickgroceries.customer.entity.AddressEntity;
import com.quickgroceries.customer.service.AddressEntityService;

@RestController
public class AddressEntityController {
    
	@Autowired
	AddressEntityService addressEntityService;
	
	@PostMapping("/customerAddress")
	public ResponseEntity<AddressEntity> addAddress(@RequestBody AddressEntity addressEntity){
		AddressEntity customerAddress = addressEntityService.addCustomerAddress(addressEntity);
		return new ResponseEntity<AddressEntity>(customerAddress,HttpStatus.CREATED);
	}

	@GetMapping("/getCustomerAddress/{uidpk}")
	public ResponseEntity<Object> getAddressById(@PathVariable long uidpk){
		Optional<AddressEntity> addressDetails = addressEntityService.getCustomerAddress(uidpk);
		 return new ResponseEntity<>(addressDetails,HttpStatus.OK);
	}
	
} 

