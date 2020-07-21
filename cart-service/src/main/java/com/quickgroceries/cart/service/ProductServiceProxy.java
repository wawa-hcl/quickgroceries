package com.quickgroceries.cart.service;

import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.quickgroceries.cart.model.ProductResponseDto;

//@FeignClient(name = "product-service", url = "localhost:9081")
@FeignClient(name = "zuul-server")
public interface ProductServiceProxy {

	@GetMapping("/product-service/quickgroceries/api/products/{id}")
	//@GetMapping("/quickgroceries/api/products/{id}")
	public ProductResponseDto getProductById(@PathVariable long id);

}
