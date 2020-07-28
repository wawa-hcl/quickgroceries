package com.quickgroceries.cart.model;

/**
 * The Class CartIdDto.
 */
public class CartIdDto {

	/** The cart ids. */
	private Long[] cartIds;

	/**
	 * Instantiates a new cart id dto.
	 *
	 * @param cartIds the cart ids
	 */
	public CartIdDto(Long[] cartIds) {
		super();
		this.cartIds = cartIds;
	}

	/**
	 * Instantiates a new cart id dto.
	 */
	public CartIdDto() {
		super();
	}

	/**
	 * Gets the cart ids.
	 *
	 * @return the cart ids
	 */
	public Long[] getCartIds() {
		return cartIds;
	}

	/**
	 * Sets the cart ids.
	 *
	 * @param cartIds the new cart ids
	 */
	public void setCartIds(Long[] cartIds) {
		this.cartIds = cartIds;
	}

}
