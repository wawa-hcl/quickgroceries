package com.quickgroceries.cart.service;

import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.quickgroceries.cart.model.ProductResponseDto;

@FeignClient(name = "product-service", url = "localhost:9081")
public interface ProductServiceProxy {

	@GetMapping("/quickgroceries/api/products/{id}")
	public ProductResponseDto getProductById(@PathVariable long id);

}
