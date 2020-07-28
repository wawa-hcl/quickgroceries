package com.quickgroceries.product.model;

/**
 * The Class ListPrice.
 */
public class ListPrice {

	/** The amount. */
	private Double amount;

	/** The currency. */
	private String currency;

	/**
	 * Instantiates a new list price.
	 *
	 * @param amount   the amount
	 * @param currency the currency
	 */
	public ListPrice(Double amount, String currency) {
		super();
		this.amount = amount;
		this.currency = currency;
	}

	/**
	 * Instantiates a new list price.
	 */
	public ListPrice() {
		super();
	}

	/**
	 * Gets the amount.
	 *
	 * @return the amount
	 */
	public Double getAmount() {
		return amount;
	}

	/**
	 * Sets the amount.
	 *
	 * @param amount the new amount
	 */
	public void setAmount(Double amount) {
		this.amount = amount;
	}

	/**
	 * Gets the currency.
	 *
	 * @return the currency
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * Sets the currency.
	 *
	 * @param currency the new currency
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}

}
