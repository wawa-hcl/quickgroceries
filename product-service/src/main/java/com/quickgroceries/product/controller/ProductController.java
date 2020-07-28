package com.quickgroceries.product.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quickgroceries.product.model.RequestDto;
import com.quickgroceries.product.model.ResponseDto;
import com.quickgroceries.product.service.ProductService;

/**
 * The Class ProductController.
 */
@RestController
@RequestMapping("quickgroceries/api/products")
public class ProductController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	/** The product service. */
	@Autowired
	ProductService productService;

	/**
	 * Adds the product.
	 *
	 * @param requestDto the request dto
	 * @return the response entity
	 */
	@PostMapping()
	@Consumes("application/json")
	public ResponseEntity<Object> addProduct(@RequestBody RequestDto requestDto) {
		logger.info("Inside addProduct method");
		Long responseDto = productService.addService(requestDto);

		return new ResponseEntity<>("id:" + responseDto, HttpStatus.CREATED);
	}

	/**
	 * Gets the products.
	 *
	 * @return the products
	 */
	@GetMapping()
	@Produces("application/json")
	public ResponseEntity<List<ResponseDto>> getProducts() {
		logger.info("Inside getProducts method");
		List<ResponseDto> responseDto = productService.getAllProducts();

		return new ResponseEntity<>(responseDto, HttpStatus.OK);

	}

	/**
	 * Gets the product by id.
	 *
	 * @param id the id
	 * @return the product by id
	 */
	@GetMapping("/{id}")
	@Produces("application/json")
	public ResponseEntity<ResponseDto> getProductById(@PathVariable long id) {
		logger.info("Inside getProductById method");
		ResponseDto responseDto = productService.getProductById(id);

		return new ResponseEntity<>(responseDto, HttpStatus.OK);

	}
}
