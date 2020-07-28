package com.quickgroceries.product.service;

import java.util.List;

import com.quickgroceries.product.model.RequestDto;
import com.quickgroceries.product.model.ResponseDto;

/**
 * The Interface ProductService.
 */
public interface ProductService {

	/**
	 * Gets the all products.
	 *
	 * @return the all products
	 */
	List<ResponseDto> getAllProducts();

	/**
	 * Adds the service.
	 *
	 * @param requestDto the request dto
	 * @return the long
	 */
	Long addService(RequestDto requestDto);

	/**
	 * Gets the product by id.
	 *
	 * @param id the id
	 * @return the product by id
	 */
	ResponseDto getProductById(long id);

}
