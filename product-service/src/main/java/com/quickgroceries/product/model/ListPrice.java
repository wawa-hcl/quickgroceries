package com.quickgroceries.product.model;

public class ListPrice {
	
	private Double amount;
	
	private String currency;

	public ListPrice(Double amount, String currency) {
		super();
		this.amount = amount;
		this.currency = currency;
	}

	public ListPrice() {
		super();
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}


	
}
