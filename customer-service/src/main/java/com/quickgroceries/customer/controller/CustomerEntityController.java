package com.quickgroceries.customer.controller;


import java.util.Arrays;
import java.util.List;
import javax.validation.Valid;
import com.quickgroceries.customer.entityDto.CustomerRequestDto;
import com.quickgroceries.customer.entityDto.CustomerResponseDto;
import com.quickgroceries.customer.entityDto.WalletRequestDto;
import com.quickgroceries.customer.serviceImpl.CustomerServiceImpl;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



@RestController
public class CustomerEntityController {

    @Autowired
    CustomerServiceImpl customerEntityService;
    @Autowired
    CallWalletService callWalletService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @PostMapping(value = "/customers", produces = "application/json")
    public ResponseEntity<Object> addCustomerDetails(@Valid @RequestBody CustomerRequestDto customerRequestDto) {
        logger.info("add customerDetails method is Initializing"+customerRequestDto);
        long uidpk = customerEntityService.addCustomerDetails(customerRequestDto);
        return new ResponseEntity<>("customer Id : " + uidpk, HttpStatus.CREATED);
    }

    @GetMapping("/customers/{uidpk}")
    public ResponseEntity<Object> getCustomerDetailById(@Valid @PathVariable long uidpk) throws ResourceNotFoundException {
        logger.info("add getCustomerDetailById method is Initializing"+uidpk);
        CustomerResponseDto getCustomer = customerEntityService.getCustomerDetails(uidpk);

        return new ResponseEntity<>(getCustomer, HttpStatus.OK);
    }

    @PutMapping("/customers/{uidpk}")
    public ResponseEntity<Object> updateCustomerDetail
            (@PathVariable(value = "uidpk") long uidpk, @Valid @RequestBody CustomerEntity customerEntity) throws ResourceNotFoundException {
        logger.info("add updateCustomerDetail method is Initializing"+customerEntity);
        CustomerEntity updatedCustomerDetails = customerEntityService.updateCustomerDetails(uidpk, customerEntity);
        return new ResponseEntity<>(updatedCustomerDetails, HttpStatus.CREATED);
    }

    @GetMapping("/customers/wallet/{customerUid}")
    public ResponseEntity<Object> getCustomerWalletDetail(@PathVariable(value = "customerUid") long customerUid) throws ResourceNotFoundException {
        logger.info("add getCustomerWalletDetail method is Initializing"+customerUid);
        ResponseEntity<Object> wallet = callWalletService.findByUid(customerUid);
        CustomerResponseDto customerDetail = customerEntityService.getCustomerDetails(customerUid);
        List<Object> customerlist = Arrays.asList(customerDetail, wallet.getBody());
        return new ResponseEntity<>(customerlist, HttpStatus.OK);
    }

    @PostMapping("/wallet/customers/{customerUid}")
    public ResponseEntity<Object> addWallet(@PathVariable(value = "customerUid")
                                                    long customerUid, @RequestBody WalletRequestDto walletRequestDto) throws ResourceNotFoundException {
        logger.info("add addWallet method is Initializing"+walletRequestDto);
        return callWalletService.addWallet(customerUid, walletRequestDto);
    }
    @GetMapping("/wallet/customer/{customerUid}")
    public ResponseEntity<Object>updatedWallet (@PathVariable("customerUid") long customerUid,@RequestBody CustomerEntity customerEntity) throws ResourceNotFoundException {
        logger.info("add addWallet method is Initializing"+ customerEntity);
        ResponseEntity<Object> wallet = callWalletService.updateWallet(customerUid);
        return new ResponseEntity<>(wallet.getBody(),HttpStatus.OK);
    }
}

