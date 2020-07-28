package com.quickgroceries.product.servive.impl;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.quickgroceries.product.entity.Product;
import com.quickgroceries.product.model.ListPrice;
import com.quickgroceries.product.model.RequestDto;
import com.quickgroceries.product.model.ResponseDto;
import com.quickgroceries.product.repository.ProductRepository;
import com.quickgroceries.product.service.ProductService;

@RunWith(SpringRunner.class)
@WebMvcTest(ProductServiceImpl.class)
class ProductServiceImplTest {

	@MockBean
	ProductService productService;

	@MockBean
	ProductRepository productRepository;

	@Test
	void testAddService() {
		RequestDto mockDto = new RequestDto();
		ListPrice mockPrice = new ListPrice();
		mockDto.setProductName("Natraj Pencil");
		mockDto.setProductDescription("HB pencil lead");
		mockDto.setProductShortName("NP");
		mockPrice.setAmount(10.0);
		mockPrice.setCurrency("INR");
		mockDto.setListPrice(mockPrice);

		Product mockProduct = new Product();
		mockProduct.setUidpk(1l);
		mockProduct.setProductName("Natraj Pencil");
		mockProduct.setProductDescription("HB pencil lead");
		mockProduct.setProductShortName("NP");
		mockProduct.setListPriceAmt(10.0);
		mockProduct.setCurrency("INR");

		Mockito.when(productRepository.save(mockProduct)).thenReturn(mockProduct);

		assertThat(productService.addService(mockDto)).isEqualTo(mockProduct.getUidpk());

	}

	@Test
	void testGetAllProducts() {
		ResponseDto mockResponse = new ResponseDto();
		mockResponse.setId(1l);
		mockResponse.setProductName("Natraj Pencil");
		mockResponse.setProductDescription("HB pencil lead");
		mockResponse.setProductShortName("NP");
		ListPrice mockPrice = new ListPrice();
		mockPrice.setAmount(10.0);
		mockPrice.setCurrency("INR");
		mockResponse.setListprice(mockPrice);

		ResponseDto mockResponse1 = new ResponseDto();
		mockResponse1.setId(2l);
		mockResponse1.setProductName("Pen");
		mockResponse1.setProductDescription("Parker Pen");
		mockResponse1.setProductShortName("P1");
		ListPrice mockPrice1 = new ListPrice();
		mockPrice1.setAmount(100.0);
		mockPrice1.setCurrency("INR");
		mockResponse1.setListprice(mockPrice1);

		List<ResponseDto> list = new ArrayList<>();
		list.add(mockResponse);
		list.add(mockResponse1);

		Product mockProduct = new Product();
		mockProduct.setUidpk(1l);
		mockProduct.setProductName("Natraj Pencil");
		mockProduct.setProductDescription("HB pencil lead");
		mockProduct.setProductShortName("NP");
		mockProduct.setListPriceAmt(10.0);
		mockProduct.setCurrency("INR");

		Product mockProduct1 = new Product();
		mockProduct1.setUidpk(2l);
		mockProduct1.setProductName("Pen");
		mockProduct1.setProductDescription("Parker Pen");
		mockProduct1.setProductShortName("P1");
		mockProduct1.setListPriceAmt(100.0);
		mockProduct1.setCurrency("INR");

		List<Product> list1 = new ArrayList<>();
		list1.add(mockProduct);
		list1.add(mockProduct1);

		Mockito.when(productRepository.findAll()).thenReturn(list1);
		assertThat(productService.getAllProducts()).isEqualTo(list);

	}

	@Test
	void testGetProductById() {
		ResponseDto mockResponse = new ResponseDto();
		mockResponse.setId(1l);
		mockResponse.setProductName("Natraj Pencil");
		mockResponse.setProductDescription("HB pencil lead");
		mockResponse.setProductShortName("NP");
		ListPrice mockPrice = new ListPrice();
		mockPrice.setAmount(10.0);
		mockPrice.setCurrency("INR");
		mockResponse.setListprice(mockPrice);

		Product mockProduct = new Product();
		mockProduct.setUidpk(1l);
		mockProduct.setProductName("Natraj Pencil");
		mockProduct.setProductDescription("HB pencil lead");
		mockProduct.setProductShortName("NP");
		mockProduct.setListPriceAmt(10.0);
		mockProduct.setCurrency("INR");

		Optional<Product> oproduct = Optional.of((Product) mockProduct);

		Mockito.when(productRepository.findById(Mockito.anyLong())).thenReturn(oproduct);
		assertThat(productService.getProductById(Mockito.anyLong())).isEqualTo(mockResponse);

	}

}
