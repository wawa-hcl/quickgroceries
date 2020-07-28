package com.quickgroceries.cart.model;

/**
 * The Class UpdateStateRequestDto.
 */
public class UpdateStateRequestDto {

	/** The cart ids. */
	private Long cartIds;

	/**
	 * Instantiates a new update state request dto.
	 */
	public UpdateStateRequestDto() {
		super();
	}

	/**
	 * Instantiates a new update state request dto.
	 *
	 * @param cartIds the cart ids
	 */
	public UpdateStateRequestDto(Long cartIds) {
		super();
		this.cartIds = cartIds;
	}

	/**
	 * Gets the cart ids.
	 *
	 * @return the cart ids
	 */
	public Long getCartIds() {
		return cartIds;
	}

	/**
	 * Sets the cart ids.
	 *
	 * @param cartIds the new cart ids
	 */
	public void setCartIds(Long cartIds) {
		this.cartIds = cartIds;
	}

}
