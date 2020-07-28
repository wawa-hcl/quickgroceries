package com.quickgroceries.order;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.quickgroceries.order.model.CustomerResponseDto;

@FeignClient(name="api-gateway-server")
public interface CustomerServiceProxy {

	@GetMapping("/customer-service/quickgroceries/api/customers/{uidpk}")
 public CustomerResponseDto getCustomerDetail(@PathVariable long uidpk);
}
