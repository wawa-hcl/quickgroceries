package com.quickgroceries.cart.model;

import java.util.List;

/**
 * The Class ResponseDto.
 */
public class ResponseDto {

	/** The cart amount. */
	private Double cart_amount;

	/** The cart items. */
	private List<CartItemsDto> cartItems;

	/**
	 * Instantiates a new response dto.
	 */
	public ResponseDto() {
		super();
	}

	/**
	 * Instantiates a new response dto.
	 *
	 * @param cart_amount the cart amount
	 * @param cartItems   the cart items
	 */
	public ResponseDto(Double cart_amount, List<CartItemsDto> cartItems) {
		super();
		this.cart_amount = cart_amount;
		this.cartItems = cartItems;
	}

	/**
	 * Gets the cart amount.
	 *
	 * @return the cart amount
	 */
	public Double getCart_amount() {
		return cart_amount;
	}

	/**
	 * Sets the cart amount.
	 *
	 * @param cart_amount the new cart amount
	 */
	public void setCart_amount(Double cart_amount) {
		this.cart_amount = cart_amount;
	}

	/**
	 * Gets the cart items.
	 *
	 * @return the cart items
	 */
	public List<CartItemsDto> getCartItems() {
		return cartItems;
	}

	/**
	 * Sets the cart items.
	 *
	 * @param cartItems the new cart items
	 */
	public void setCartItems(List<CartItemsDto> cartItems) {
		this.cartItems = cartItems;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "ResponseDto [cart_amount=" + cart_amount + ", cartItems=" + cartItems + "]";
	}

}
