package com.quickgroceries.cart.model;

import java.util.List;

/**
 * The Class StateCartResponseDto.
 */
public class StateCartResponseDto {

	/** The cart ID. */
	private Long cartID;

	/** The customer ID. */
	private Long customerID;

	/** The cart amount. */
	private Double cart_amount;

	/** The cart items. */
	private List<CartItemsDto> cartItems;

	/**
	 * Instantiates a new state cart response dto.
	 */
	public StateCartResponseDto() {
		super();
	}

	/**
	 * Instantiates a new state cart response dto.
	 *
	 * @param cartID      the cart ID
	 * @param customerID  the customer ID
	 * @param cart_amount the cart amount
	 * @param cartItems   the cart items
	 */
	public StateCartResponseDto(Long cartID, Long customerID, Double cart_amount, List<CartItemsDto> cartItems) {
		super();
		this.cartID = cartID;
		this.customerID = customerID;
		this.cart_amount = cart_amount;
		this.cartItems = cartItems;
	}

	/**
	 * Gets the cart ID.
	 *
	 * @return the cart ID
	 */
	public Long getCartID() {
		return cartID;
	}

	/**
	 * Sets the cart ID.
	 *
	 * @param cartID the new cart ID
	 */
	public void setCartID(Long cartID) {
		this.cartID = cartID;
	}

	/**
	 * Gets the customer ID.
	 *
	 * @return the customer ID
	 */
	public Long getCustomerID() {
		return customerID;
	}

	/**
	 * Sets the customer ID.
	 *
	 * @param customerID the new customer ID
	 */
	public void setCustomerID(Long customerID) {
		this.customerID = customerID;
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
		return "StateCartResponseDto [cartID=" + cartID + ", customerID=" + customerID + ", cart_amount=" + cart_amount
				+ ", cartItems=" + cartItems + "]";
	}

}
