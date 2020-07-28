package com.quickgroceries.cart.model;

/**
 * The Class CartItemsDto.
 */
public class CartItemsDto {

	/** The product ID. */
	private Long productID;

	/** The quantity. */
	private int quantity;

	/**
	 * Instantiates a new cart items dto.
	 *
	 * @param productID the product ID
	 * @param quantity  the quantity
	 */
	public CartItemsDto(Long productID, int quantity) {
		super();
		this.productID = productID;
		this.quantity = quantity;
	}

	/**
	 * Instantiates a new cart items dto.
	 */
	public CartItemsDto() {
		super();
	}

	/**
	 * Gets the product ID.
	 *
	 * @return the product ID
	 */
	public Long getProductID() {
		return productID;
	}

	/**
	 * Sets the product ID.
	 *
	 * @param productID the new product ID
	 */
	public void setProductID(Long productID) {
		this.productID = productID;
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

}
