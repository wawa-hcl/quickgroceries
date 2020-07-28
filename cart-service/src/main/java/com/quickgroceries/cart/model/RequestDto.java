package com.quickgroceries.cart.model;

/**
 * The Class RequestDto.
 */
public class RequestDto {

	/** The product id. */
	private Long product_id;

	/** The quantity. */
	private int quantity;

	/** The action. */
	private Action action;

	/**
	 * Instantiates a new request dto.
	 */
	public RequestDto() {
		super();
	}

	/**
	 * Instantiates a new request dto.
	 *
	 * @param product_id the product id
	 * @param quantity   the quantity
	 * @param action     the action
	 */
	public RequestDto(Long product_id, int quantity, Action action) {
		super();
		this.product_id = product_id;
		this.quantity = quantity;
		this.action = action;
	}

	/**
	 * Gets the product id.
	 *
	 * @return the product id
	 */
	public Long getProduct_id() {
		return product_id;
	}

	/**
	 * Sets the product id.
	 *
	 * @param product_id the new product id
	 */
	public void setProduct_id(Long product_id) {
		this.product_id = product_id;
	}

	/**
	 * Gets the quantity.
	 *
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * Sets the quantity.
	 *
	 * @param quantity the new quantity
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * Gets the action.
	 *
	 * @return the action
	 */
	public Action getAction() {
		return action;
	}

	/**
	 * Sets the action.
	 *
	 * @param action the new action
	 */
	public void setAction(Action action) {
		this.action = action;
	}

}
