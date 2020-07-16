package com.quickgroceries.customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.quickgroceries.wallet.entity.WalletEntity;

@FeignClient(name="wallet-service", url = "http://localhost:9001")
public interface CallWalletService {
	
	@GetMapping("/customer/wallet/{uidpk}")
	    public ResponseEntity<Object> getWalletById(@PathVariable("uidpk") int uidpk);
	
	@PostMapping("/wallet/customer")
    public ResponseEntity<Object> addWallet(@RequestBody WalletEntity walletEntity);
}
