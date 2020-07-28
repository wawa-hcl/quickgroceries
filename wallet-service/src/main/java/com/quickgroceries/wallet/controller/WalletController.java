package com.quickgroceries.wallet.controller;

import com.quickgroceries.wallet.entity.WalletEntity;
import com.quickgroceries.wallet.entityDto.WalletRequestDto;
import com.quickgroceries.wallet.entityDto.WalletResponseDto;
import com.quickgroceries.wallet.exceptions.ResourceNotFoundException;
import com.quickgroceries.wallet.service.WalletService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class WalletController {

    @Autowired
    WalletService walletService;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @PostMapping(value = "/customer/wallet/{customerUid}",headers = {
            "content-type=application/json" })

    public ResponseEntity<Object> addWallet(@PathVariable ("customerUid") long customerUid,@RequestBody WalletRequestDto walletRequestDto ) throws ResourceNotFoundException {
        WalletRequestDto addWallet = walletService.addWallet(customerUid,walletRequestDto);
        logger.info("Intializing add method wallet");
        return new ResponseEntity<>(addWallet, HttpStatus.CREATED);
    }
    @GetMapping(value = "/customer/wallet/{customerUid}")
    public ResponseEntity<Object> findWalletByUid(@PathVariable("customerUid") long customerUid) throws ResourceNotFoundException{
        logger.info("Intializing findByUid method wallet");
        return new ResponseEntity<>(walletService.getWalletAmount(customerUid),HttpStatus.OK);
    }
    @PutMapping("/wallet/customers/{customerUid}")
    public ResponseEntity<Object> updateWallet(@PathVariable ("customerUid") long customerUid){
        WalletResponseDto updatedWallet = walletService.updateWallet(customerUid);
        return new ResponseEntity<>(updatedWallet,HttpStatus.CREATED);
    }

}
