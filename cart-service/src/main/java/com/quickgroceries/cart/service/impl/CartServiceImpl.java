package com.quickgroceries.cart.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quickgroceries.cart.entity.Cart;
import com.quickgroceries.cart.entity.CartItem;
import com.quickgroceries.cart.entity.State;
import com.quickgroceries.cart.exception.CartNotFoundException;
import com.quickgroceries.cart.model.Action;
import com.quickgroceries.cart.model.CartIdDto;
import com.quickgroceries.cart.model.CartItemsDto;
import com.quickgroceries.cart.model.ProductResponseDto;
import com.quickgroceries.cart.model.RequestDto;
import com.quickgroceries.cart.model.ResponseDto;
import com.quickgroceries.cart.model.StateCartResponseDto;
import com.quickgroceries.cart.repository.CartItemRepository;
import com.quickgroceries.cart.repository.CartRepository;
import com.quickgroceries.cart.service.CartService;
import com.quickgroceries.cart.service.ProductServiceProxy;

/**
 * The Class CartServiceImpl.
 */
@Service
public class CartServiceImpl implements CartService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	/** The cart repository. */
	@Autowired
	CartRepository cartRepository;

	/** The cart item repository. */
	@Autowired
	CartItemRepository cartItemRepository;

	/** The product service proxy. */
	@Autowired
	ProductServiceProxy productServiceProxy;

	/**
	 * Adds the cart and items bycustomer uid.
	 *
	 * @param customerID the customer ID
	 * @param requestDto the request dto
	 * @return the int
	 */
	@Override
	public int addCartAndItemsBycustomerUid(long customerID, RequestDto requestDto) {
		logger.info("Inside addCartAndItemsBycustomerUid method");

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
					cartitem.setCart(cart);
					cartItemRepository.save(cartitem);
				}

			}
			logger.info("Cart already present and new item added: {}", cart);
			return 1;

		} else if (requestDto.getAction().equals(Action.ADD)) {
			Cart cart = new Cart();
			CartItem cartitem = new CartItem();
			List<CartItem> l = new ArrayList<>();
			cart.setCustomerUid(customerID);
			cart.setState(State.OPEN);

			cartitem.setProductUid(requestDto.getProduct_id());
			cartitem.setQuantity(requestDto.getQuantity());
			cartitem.setCart(cart);
			l.add(cartitem);
			cart.setCartItem(l);
			cartRepository.save(cart);
			logger.info("New cart made and new item added: {}", cart);
			return 1;
		}

		return 0;
	}

	/**
	 * Update cart and items bycustomer uid.
	 *
	 * @param customerID the customer ID
	 * @param requestDto the request dto
	 * @return the int
	 */
	@Override
	public int updateCartAndItemsBycustomerUid(long customerID, RequestDto requestDto) {
		logger.info("Inside updateCartAndItemsBycustomerUid method");

		Optional<Cart> dbcart = cartRepository.findByCustomerUid(customerID);
		if (dbcart.isPresent()) {
			Cart cart = dbcart.get();
			List<CartItem> dbcartitem = cart.getCartItem();
			for (CartItem ci : dbcartitem) {
				if (ci.getProductUid().equals(requestDto.getProduct_id())
						&& (requestDto.getAction().equals(Action.UPDATE))) {
					int newQuantity = ci.getQuantity() + (requestDto.getQuantity());

					ci.setQuantity(newQuantity);
					cartItemRepository.save(ci);
					logger.info("Item quantity added: {}", cart);
					return 1;
				}

				else if (ci.getProductUid().equals(requestDto.getProduct_id())
						&& (requestDto.getAction().equals(Action.DELETE))) {
					int newQuantity = ci.getQuantity() - (requestDto.getQuantity());

					ci.setQuantity(newQuantity);
					cartItemRepository.save(ci);
					logger.info("Item quantity deleted: {}", cart);
					return 1;
				}
			}
		}
		throw new CartNotFoundException("Cart not found in database " + customerID);
	}

	/**
	 * Clear cart iems by customer id.
	 *
	 * @param customerID the customer ID
	 * @return the int
	 */
	@Override
	public int clearCartIemsByCustomerId(long customerID) {
		logger.info("Inside clearCartIemsByCustomerId method");

		Optional<Cart> dbcart = cartRepository.findByCustomerUid(customerID);
		if (dbcart.isPresent()) {
			Cart cart = dbcart.get();

			cartRepository.delete(cart);

			logger.info("Cart deleted against customer ID: {}", customerID);
			return 1;
		}

		throw new CartNotFoundException("Cart not found in database " + customerID);
	}

	/**
	 * Gets the customer cart by customer id.
	 *
	 * @param customerID the customer ID
	 * @return the customer cart by customer id
	 */
	@Override
	public ResponseDto getCustomerCartByCustomerId(long customerID) {
		logger.info("Inside getCustomerCartByCustomerId method");

		ResponseDto responseDto = new ResponseDto();
		List<CartItemsDto> cartList = new ArrayList<>();

		Optional<Cart> dbcart = cartRepository.findByCustomerUid(customerID);
		double pamount = 0;
		if (dbcart.isPresent()) {
			Cart cart = dbcart.get();
			List<CartItem> dbcartitem = cart.getCartItem();

			for (CartItem ci : dbcartitem) {
				CartItemsDto cartItemsDto = new CartItemsDto();
				cartItemsDto.setProductID(ci.getProductUid());
				cartItemsDto.setQuantity(ci.getQuantity());
				cartList.add(cartItemsDto);
				ProductResponseDto productResponseDto = productServiceProxy.getProductById(ci.getProductUid());
				pamount = pamount + (ci.getQuantity() * productResponseDto.getListprice().getAmount());

			}
			responseDto.setCart_amount(pamount);
			responseDto.setCartItems(cartList);

		}

		logger.info("Cart against {}", customerID + ":" + responseDto);
		return responseDto;
	}

	/**
	 * Gets the cart by state.
	 *
	 * @param stateValue the state value
	 * @return the cart by state
	 */
	@Override
	public List<StateCartResponseDto> getCartByState(State stateValue) {
		logger.info("Inside getCartByState method");

		List<StateCartResponseDto> list = new ArrayList<>();

		cartRepository.findByState(stateValue).forEach(lcart -> {
			StateCartResponseDto stateCartResponseDto = new StateCartResponseDto();
			double pamount = 0;
			List<CartItemsDto> cartList = new ArrayList<>();

			stateCartResponseDto.setCartID(lcart.getCartUidpk());
			stateCartResponseDto.setCustomerID(lcart.getCustomerUid());
			List<CartItem> lcartItem = lcart.getCartItem();
			for (CartItem ci : lcartItem) {
				CartItemsDto cartItemsDto = new CartItemsDto();
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

		logger.info("Carts against" + stateValue + ":" + list);
		return list;
	}

	/**
	 * Update cart state by ids.
	 *
	 * @param stateValue the state value
	 * @param cartIdDto  the cart id dto
	 * @return the int
	 */
	@Override
	public int updateCartStateByIds(State stateValue, CartIdDto cartIdDto) {
		logger.info("Inside updateCartStateByIds method");

		Long[] ids = cartIdDto.getCartIds();

		for (long i : ids) {
			Optional<Cart> ocart = cartRepository.findById(i);
			if (ocart.isPresent()) {
				Cart ucart = ocart.get();

				ucart.setState(stateValue);

				cartRepository.save(ucart);

			}
			logger.info("State of carts with ids: {}", cartIdDto + ":" + "updated to {}", stateValue);
			return 1;
		}
		return 0;

	}

}
