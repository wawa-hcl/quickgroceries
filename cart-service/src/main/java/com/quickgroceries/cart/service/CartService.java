package com.quickgroceries.cart.service;

import java.util.List;

import com.quickgroceries.cart.entity.State;
import com.quickgroceries.cart.model.RequestDto;
import com.quickgroceries.cart.model.ResponseDto;
import com.quickgroceries.cart.model.StateCartResponseDto;

public interface CartService {

	int addCartAndItemsBycustomerUid(long customerID, RequestDto requestDto);

	int updateCartAndItemsBycustomerUid(long customerID, RequestDto requestDto);

	int clearCartIemsByCustomerId(long customerID);

	ResponseDto getCustomerCartByCustomerId(long customerID);

	List<StateCartResponseDto> getCartByState(State stateValue);

	int updateCartStateByIds(State stateValue, long[] cartIds);

}
