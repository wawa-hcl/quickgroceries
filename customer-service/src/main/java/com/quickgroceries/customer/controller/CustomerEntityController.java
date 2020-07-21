package com.quickgroceries.customer.controller;


import java.util.Arrays;
import java.util.List;
import javax.validation.Valid;
import com.quickgroceries.customer.entityDto.CustomerRequestDto;
import com.quickgroceries.customer.entityDto.CustomerResponseDto;
import com.quickgroceries.customer.entityDto.WalletRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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


@RestController
public class CustomerEntityController {
    
	@Autowired
	CustomerEntityService customerEntityService;
	@Autowired
	CallWalletService callWalletService;

	@PostMapping(value ="/customers",produces = "application/json")
	public ResponseEntity<Object>addCustomerDetails (@Valid @RequestBody CustomerRequestDto customerRequestDto){
	    long uidpk = customerEntityService.addCustomerDetails(customerRequestDto);
	return new ResponseEntity<>("customer Id : "+uidpk,HttpStatus.CREATED);
	}

	@GetMapping("/customers/{uidpk}")
	public ResponseEntity<Object> getCustomerDetailById(@Valid @PathVariable long uidpk) throws ResourceNotFoundException{
	CustomerResponseDto getCustomer = customerEntityService.getCustomerDetails(uidpk);
	return new ResponseEntity<>(getCustomer,HttpStatus.OK);
	}

	@PutMapping("/customers/{uidpk}")
	 public ResponseEntity<Object> updateCustomerDetail
	 (@PathVariable(value = "uidpk") long uidpk, @Valid @RequestBody CustomerEntity customerEntity) throws ResourceNotFoundException {
      CustomerEntity updatedCustomerDetails = customerEntityService.updateCustomerDetails(uidpk, customerEntity);
	   return new ResponseEntity<>(updatedCustomerDetails,HttpStatus.CREATED);
	}

	@GetMapping("/customers/wallet/{customerUid}")
	public ResponseEntity<Object> getCustomerDetail (@PathVariable(value = "customerUid") long customerUid) throws ResourceNotFoundException {
		ResponseEntity<Object> wallet = callWalletService.findByUid(customerUid);
		CustomerResponseDto customerDetail = customerEntityService.getCustomerDetails(customerUid);
		List<Object> customerlist = Arrays.asList(customerDetail,wallet.getBody());
		return new ResponseEntity<>(customerlist,HttpStatus.OK);
	}
	@PostMapping("/wallet/customers/{customerUid}")
	public ResponseEntity<Object> addWallet (@PathVariable (value = "customerUid")
															   long customerUid, @RequestBody WalletRequestDto walletRequestDto) throws ResourceNotFoundException {
		return callWalletService.addWallet(customerUid,walletRequestDto);
	}
}

