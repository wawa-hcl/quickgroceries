package com.quickgroceries.customer;
import com.quickgroceries.customer.entityDto.WalletRequestDto;
import com.quickgroceries.customer.exceptions.ResourceNotFoundException;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


//@FeignClient(name="wallet-service", url = "http://localhost:9001")
@FeignClient(name = "apiGateWay-server")
public interface CallWalletService {

    @GetMapping(value = "/wallet-service/customer/wallet/{customerUid}")
    public ResponseEntity<Object> findByUid(@PathVariable("customerUid") long customerUid);

    @PostMapping(value = "/customer/wallet/{customerUid}",headers = {
            "content-type=application/json" })
    public ResponseEntity<Object> addWallet(@PathVariable ("customerUid")
                                                    long customerUid,@RequestBody WalletRequestDto walletRequestDto ) throws ResourceNotFoundException;

}
