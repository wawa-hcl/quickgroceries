package com.quickgroceries.cart.service;

import java.util.List;

import com.quickgroceries.cart.entity.State;
import com.quickgroceries.cart.model.CartIdDto;
import com.quickgroceries.cart.model.RequestDto;
import com.quickgroceries.cart.model.ResponseDto;
import com.quickgroceries.cart.model.StateCartResponseDto;

/**
 * The Interface CartService.
 */
public interface CartService {

	/**
	 * Adds the cart and items bycustomer uid.
	 *
	 * @param customerID the customer ID
	 * @param requestDto the request dto
	 * @return the int
	 */
	int addCartAndItemsBycustomerUid(long customerID, RequestDto requestDto);

	/**
	 * Update cart and items bycustomer uid.
	 *
	 * @param customerID the customer ID
	 * @param requestDto the request dto
	 * @return the int
	 */
	int updateCartAndItemsBycustomerUid(long customerID, RequestDto requestDto);

	/**
	 * Clear cart iems by customer id.
	 *
	 * @param customerID the customer ID
	 * @return the int
	 */
	int clearCartIemsByCustomerId(long customerID);

	/**
	 * Gets the customer cart by customer id.
	 *
	 * @param customerID the customer ID
	 * @return the customer cart by customer id
	 */
	ResponseDto getCustomerCartByCustomerId(long customerID);

	/**
	 * Gets the cart by state.
	 *
	 * @param stateValue the state value
	 * @return the cart by state
	 */
	List<StateCartResponseDto> getCartByState(State stateValue);

	/**
	 * Update cart state by ids.
	 *
	 * @param stateValue the state value
	 * @param cartIdDto  the cart id dto
	 * @return the int
	 */
	int updateCartStateByIds(State stateValue, CartIdDto cartIdDto);

}
