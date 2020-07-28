package com.quickgroceries.cart.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

/**
 * The Class CartController.
 */
@RestController
@RequestMapping("quickgroceries/api")
public class CartController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	/** The cart service. */
	@Autowired
	CartService cartService;

	/**
	 * Alter items in cart.
	 *
	 * @param customerID the customer ID
	 * @param requestDto the request dto
	 * @return the response entity
	 */
	@PostMapping("/cart/customer/{customerID}")
	public ResponseEntity<HttpStatus> alterItemsInCart(@PathVariable long customerID,
			@RequestBody RequestDto requestDto) {
		logger.info("Inside alterItemsInCart method");

		int i = cartService.addCartAndItemsBycustomerUid(customerID, requestDto);
		if (i == 1) {
			return new ResponseEntity<>(HttpStatus.CREATED);
		}
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
	}

	/**
	 * Update items in cart.
	 *
	 * @param customerID the customer ID
	 * @param requestDto the request dto
	 * @return the response entity
	 */
	@PutMapping("/cart/customer/{customerID}")
	public ResponseEntity<HttpStatus> updateItemsInCart(@PathVariable long customerID,
			@RequestBody RequestDto requestDto) {
		logger.info("Inside updateItemsInCart method");

		int i = cartService.updateCartAndItemsBycustomerUid(customerID, requestDto);
		if (i == 1) {
			return new ResponseEntity<>(HttpStatus.CREATED);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	}

	/**
	 * Clear cart iems.
	 *
	 * @param customerID the customer ID
	 * @return the response entity
	 */
	@DeleteMapping("/cart/customer/{customerID}")
	public ResponseEntity<HttpStatus> clearCartIems(@PathVariable long customerID) {
		logger.info("Inside clearCartIems method");

		int i = cartService.clearCartIemsByCustomerId(customerID);
		if (i == 1) {
			return new ResponseEntity<>(HttpStatus.CREATED);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	/**
	 * Gets the customer cart.
	 *
	 * @param customerID the customer ID
	 * @return the customer cart
	 */
	@GetMapping("/cart/customer/{customerID}")
	public ResponseEntity<ResponseDto> getCustomerCart(@PathVariable long customerID) {
		logger.info("Inside getCustomerCart method");

		ResponseDto responseDto = cartService.getCustomerCartByCustomerId(customerID);

		return new ResponseEntity<>(responseDto, HttpStatus.OK);
	}

	/**
	 * Gets the cart by state.
	 *
	 * @param stateValue the state value
	 * @return the cart by state
	 */
	@GetMapping("/cart")
	public ResponseEntity<List<StateCartResponseDto>> getCartByState(
			@RequestHeader(value = "STATE", required = true) State stateValue) {
		logger.info("Inside getCartByState method");

		List<StateCartResponseDto> li = cartService.getCartByState(stateValue);

		return new ResponseEntity<>(li, HttpStatus.OK);
	}

	/**
	 * Update cart state.
	 *
	 * @param stateValue the state value
	 * @param cartIdDto  the cart id dto
	 * @return the response entity
	 */
	@PutMapping("/cart")
	public ResponseEntity<HttpStatus> updateCartState(@RequestHeader(value = "STATE", required = true) State stateValue,
			@RequestBody CartIdDto cartIdDto) {
		logger.info("Inside updateCartState method");

		int i = cartService.updateCartStateByIds(stateValue, cartIdDto);

		if (i == 1) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

}
