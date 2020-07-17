package com.quickgroceries.product.servive.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.quickgroceries.product.entity.Product;
import com.quickgroceries.product.exception.ProductNotFoundException;
import com.quickgroceries.product.model.ListPrice;
import com.quickgroceries.product.model.RequestDto;
import com.quickgroceries.product.model.ResponseDto;
import com.quickgroceries.product.repository.ProductRepository;
import com.quickgroceries.product.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;

	@Override
	public Long addService(RequestDto requestDto) {
		Product product = new Product();

		product.setProductName(requestDto.getProductName());
		product.setProductDescription(requestDto.getProductDescription());
		product.setProductShortName(requestDto.getProductShortName());
		product.setListPriceAmt(requestDto.getListPrice().getAmount());
		product.setCurrency(requestDto.getListPrice().getCurrency());

		productRepository.save(product);

		return product.getUidpk();
	}

	@Override
	public List<ResponseDto> getAllProducts() {

		List<ResponseDto> list = new ArrayList<ResponseDto>();

		productRepository.findAll().forEach(product -> {
			ResponseDto responseDto = new ResponseDto();
			ListPrice listPrice = new ListPrice();
			responseDto.setId(product.getUidpk());
			responseDto.setProductName(product.getProductName());
			responseDto.setProductDescription(product.getProductDescription());
			responseDto.setProductShortName(product.getProductShortName());

			listPrice.setAmount(product.getListPriceAmt());
			;
			listPrice.setCurrency(product.getCurrency());

			responseDto.setListprice(listPrice);
			list.add(responseDto);
		});

		return list;
	}

	@Override
	public ResponseDto getProductById(long id) {
		ResponseDto responseDto = new ResponseDto();
		ListPrice listPrice = new ListPrice();
		Optional<Product> proDb = productRepository.findById(id);
		if (proDb.isPresent()) {
			Product p1 = proDb.get();

			responseDto.setId(p1.getUidpk());
			responseDto.setProductName(p1.getProductName());
			responseDto.setProductDescription(p1.getProductDescription());
			responseDto.setProductShortName(p1.getProductShortName());
			listPrice.setAmount(p1.getListPriceAmt());
			;
			listPrice.setCurrency(p1.getCurrency());

			responseDto.setListprice(listPrice);

			return responseDto;
		}

		throw new ProductNotFoundException("Product not found in database " + id);
	}

}
