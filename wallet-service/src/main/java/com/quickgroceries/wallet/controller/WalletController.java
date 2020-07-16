package com.quickgroceries.wallet.controller;

import java.io.Serializable;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.quickgroceries.wallet.entity.WalletEntity;
import com.quickgroceries.wallet.service.WalletService;

@RestController
public class WalletController implements Serializable {
    
	private static final long serialVersionUID = 1L;
	@Autowired
    WalletService walletService;
    
    @PostMapping("/wallet/customer")
    public ResponseEntity<Object> addWallet(@RequestBody WalletEntity walletEntity) {
    	WalletEntity wallet = walletService.addMoney(walletEntity);
    	return new ResponseEntity<>(wallet,HttpStatus.CREATED);
    	
    }
  
    @GetMapping("/customer/wallet/{uidpk}")
    public ResponseEntity<Object> getWalletById(@PathVariable("uidpk") int uidpk){
    	 WalletEntity wallet =walletService.getWalletById(uidpk);
    	return new ResponseEntity<>(wallet,HttpStatus.OK);
    	
    }
}
