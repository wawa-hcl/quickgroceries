package com.quickgroceries.product.service;

import java.util.List;



import com.quickgroceries.product.model.RequestDto;
import com.quickgroceries.product.model.ResponseDto;


public interface ProductService {

	List<ResponseDto> getAllProducts();

	Long addService(RequestDto requestDto);

	ResponseDto getProductById(long id);

	

}
