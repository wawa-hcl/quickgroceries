package com.quickgroceries.product.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;

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



@RestController
@RequestMapping("quickgroceries/api")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@PostMapping("/products")
	@Consumes("application/json")
	public ResponseEntity<Object> addProduct(@RequestBody RequestDto requestDto ){
		
		Long responseDto= productService.addService(requestDto);
		
		return new ResponseEntity<>("id:"+responseDto,HttpStatus.CREATED);
	}

	@GetMapping("/products")
	@Produces("application/json")
	public ResponseEntity<List<ResponseDto>> getProducts(){
		
		List<ResponseDto> responseDto=productService.getAllProducts();
		
		return new ResponseEntity<>(responseDto,HttpStatus.OK);
		
	}
	
	@GetMapping("/products/{id}")
	@Produces("application/json")
	public ResponseEntity<ResponseDto> getProductById(@PathVariable long  id){
		
		ResponseDto responseDto=productService.getProductById(id);
		
		return new ResponseEntity<>(responseDto,HttpStatus.OK);
		
	}
}
