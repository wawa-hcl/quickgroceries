package com.quickgroceries.cart.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quickgroceries.cart.entity.Cart;
import com.quickgroceries.cart.entity.CartItem;
import com.quickgroceries.cart.entity.State;
import com.quickgroceries.cart.model.Action;
import com.quickgroceries.cart.model.CartItemsDto;
import com.quickgroceries.cart.model.ProductResponseDto;
import com.quickgroceries.cart.model.RequestDto;
import com.quickgroceries.cart.model.ResponseDto;
import com.quickgroceries.cart.model.StateCartResponseDto;
import com.quickgroceries.cart.repository.CartItemRepository;
import com.quickgroceries.cart.repository.CartRepository;
import com.quickgroceries.cart.service.CartService;
import com.quickgroceries.cart.service.ProductServiceProxy;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	CartRepository cartRepository;

	@Autowired
	CartItemRepository cartItemRepository;

	@Autowired
	ProductServiceProxy productServiceProxy;

	@Override
	public int addCartAndItemsBycustomerUid(long customerID, RequestDto requestDto) {

		Optional<Cart> dbcart = cartRepository.findByCustomerUid(customerID);
		if (dbcart.isPresent()) {
			Cart cart = dbcart.get();
			List<CartItem> dbcartitem = cart.getCartItem();
			for (CartItem ci : dbcartitem) {
				if (!ci.getProductUid().equals(requestDto.getProduct_id())
						&& (requestDto.getAction().equals(Action.ADD))) {
					CartItem cartitem = new CartItem();
					cartitem.setProductUid(requestDto.getProduct_id());
					cartitem.setQuantity(requestDto.getQuantity());
					//cartitem.set(cart.getCartUidpk());
					cartItemRepository.save(cartitem);
				}

			}
			return 1;

		} else if (!dbcart.isPresent() && (requestDto.getAction().equals(Action.ADD))) {
			Cart cart = new Cart();
			CartItem cartitem = new CartItem();
			List<CartItem> l = new ArrayList<CartItem>();
			cart.setCustomerUid(customerID);
			cart.setState(State.OPEN);

			cartitem.setProductUid(requestDto.getProduct_id());
			cartitem.setQuantity(requestDto.getQuantity());
			l.add(cartitem);
			cart.setCartItem(l);
			cartRepository.save(cart);
			return 1;
		}

		return 0;
	}
	
	
	@Override
	public int updateCartAndItemsBycustomerUid(long customerID, RequestDto requestDto) {
		Optional<Cart> dbcart = cartRepository.findByCustomerUid(customerID);
		if (dbcart.isPresent()) {
			Cart cart = dbcart.get();
			List<CartItem> dbcartitem = cart.getCartItem();
			for (CartItem ci : dbcartitem) {
				if(ci.getProductUid().equals(requestDto.getProduct_id()) && (requestDto.getAction().equals(Action.UPDATE))) {
					int newQuantity = ci.getQuantity() + (requestDto.getQuantity());

					ci.setQuantity(newQuantity);
					cartItemRepository.save(ci);
					return 1;
				}
				
				else if(ci.getProductUid().equals(requestDto.getProduct_id()) && (requestDto.getAction().equals(Action.DELETE))) {
					int newQuantity = ci.getQuantity() - (requestDto.getQuantity());

					ci.setQuantity(newQuantity);
					cartItemRepository.save(ci);
					return 1;
				}
			}
		}
		return 0;
	}

	
	@Override
	public int clearCartIemsByCustomerId(long customerID) {
		Optional<Cart> dbcart = cartRepository.findByCustomerUid(customerID);
		if(dbcart.isPresent()) {
			Cart cart = dbcart.get();
			List<CartItem> dbcartitem = cart.getCartItem();
			for(CartItem ci:dbcartitem) {
				cartItemRepository.delete(ci);
			}
			return 1;
		}

		return 0;
	}

	
	
	@Override
	public ResponseDto getCustomerCartByCustomerId(long customerID) {

		ResponseDto responseDto = new ResponseDto();
		List<CartItemsDto> cartList = new ArrayList<CartItemsDto>();
		CartItemsDto cartItemsDto = new CartItemsDto();

		Optional<Cart> dbcart = cartRepository.findByCustomerUid(customerID);
		double pamount = 0;
		if (dbcart.isPresent()) {
			Cart cart = dbcart.get();
			List<CartItem> dbcartitem = cart.getCartItem();

			for (CartItem ci : dbcartitem) {

				cartItemsDto.setProductID(ci.getProductUid());
				cartItemsDto.setQuantity(ci.getQuantity());
				ProductResponseDto productResponseDto = productServiceProxy.getProductById(ci.getProductUid());
				pamount = pamount + (ci.getQuantity() * productResponseDto.getListprice().getAmount());
				cartList.add(cartItemsDto);
			}

		}
		responseDto.setCart_amount(pamount);
		responseDto.setCartItems(cartList);

		return responseDto;
	}

	
	
	@Override
	public List<StateCartResponseDto> getCartByState(State stateValue) {

		List<StateCartResponseDto> list = new ArrayList<StateCartResponseDto>();
		List<CartItemsDto> cartList = new ArrayList<CartItemsDto>();
		CartItemsDto cartItemsDto = new CartItemsDto();

		cartRepository.findByState(stateValue).forEach(lcart -> {
			StateCartResponseDto stateCartResponseDto = new StateCartResponseDto();
			double pamount = 0;

			stateCartResponseDto.setCartID(lcart.getCartUidpk());
			stateCartResponseDto.setCustomerID(lcart.getCustomerUid());
			List<CartItem> lcartItem = lcart.getCartItem();
			for (CartItem ci : lcartItem) {

				cartItemsDto.setProductID(ci.getProductUid());
				cartItemsDto.setQuantity(ci.getQuantity());
				ProductResponseDto productResponseDto = productServiceProxy.getProductById(ci.getProductUid());
				pamount = pamount + (ci.getQuantity() * productResponseDto.getListprice().getAmount());
				cartList.add(cartItemsDto);

			}

			stateCartResponseDto.setCart_amount(pamount);
			stateCartResponseDto.setCartItems(cartList);

			list.add(stateCartResponseDto);
		});

		return list;
	}

	
	
	@Override
	public int updateCartStateByIds(State stateValue, long[] cartIds) {
		long[] ids = cartIds;

		for (long i : ids) {
			Optional<Cart> ocart = cartRepository.findById(i);
			if (ocart.isPresent()) {
				Cart ucart = ocart.get();

				ucart.setState(stateValue);

				cartRepository.save(ucart);

			}
			return 1;
		}
		return 0;

	}



}
