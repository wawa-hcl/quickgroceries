package com.quickgroceries.cart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quickgroceries.cart.entity.State;
import com.quickgroceries.cart.model.CartIdDto;
import com.quickgroceries.cart.model.RequestDto;
import com.quickgroceries.cart.model.ResponseDto;
import com.quickgroceries.cart.model.StateCartResponseDto;
import com.quickgroceries.cart.service.CartService;

@RestController
@RequestMapping("quickgroceries/api")
public class CartController {

	@Autowired
	CartService cartService;

	@PostMapping("/cart/customer/{customerID}")
	public ResponseEntity<HttpStatus> alterItemsInCart(@PathVariable long customerID,
			@RequestBody RequestDto requestDto) {

		int i = cartService.addCartAndItemsBycustomerUid(customerID, requestDto);
		if (i == 1) {
			return new ResponseEntity<>(HttpStatus.CREATED);
		}
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
	}

	@PutMapping("/cart/customer/{customerID}")
	public ResponseEntity<HttpStatus> updateItemsInCart(@PathVariable long customerID,
			@RequestBody RequestDto requestDto) {
		int i = cartService.updateCartAndItemsBycustomerUid(customerID, requestDto);
		if (i == 1) {
			return new ResponseEntity<>(HttpStatus.CREATED);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	}

	@DeleteMapping("/cart/customer/{customerID}")
	public ResponseEntity<HttpStatus> clearCartIems(@PathVariable long customerID) {

		int i = cartService.clearCartIemsByCustomerId(customerID);
		if (i == 1) {
			return new ResponseEntity<>(HttpStatus.CREATED);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@GetMapping("/cart/customer/{customerID}")
	public ResponseEntity<ResponseDto> getCustomerCart(@PathVariable long customerID) {

		ResponseDto responseDto = cartService.getCustomerCartByCustomerId(customerID);

		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	@GetMapping("/cart")
	public ResponseEntity<List<StateCartResponseDto>> getCartByState(
			@RequestHeader(value = "STATE", required = true) State stateValue) {

		List<StateCartResponseDto> li = cartService.getCartByState(stateValue);

		return new ResponseEntity<>(li, HttpStatus.OK);
	}

	@PutMapping("/cart")
	public ResponseEntity<HttpStatus> updateCartState(@RequestHeader(value = "STATE", required = true) State stateValue,
			@RequestBody CartIdDto cartIdDto) {
		int i = cartService.updateCartStateByIds(stateValue, cartIdDto);

		if (i == 1) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

}
