package com.quickgroceries.cart.service;

import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.quickgroceries.cart.model.ProductResponseDto;

/**
 * The Interface ProductServiceProxy.
 */

//@FeignClient(name = "product-service", url = "localhost:9081")
@FeignClient(name = "api-gateway-server")
public interface ProductServiceProxy {

	/**
	 * Gets the product by id.
	 *
	 * @param id the id
	 * @return the product by id
	 */
	@GetMapping("/product-service/quickgroceries/api/products/{id}")
	// @GetMapping("/quickgroceries/api/products/{id}")
	public ProductResponseDto getProductById(@PathVariable long id);

}
