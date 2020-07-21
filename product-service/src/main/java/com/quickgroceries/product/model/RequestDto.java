package com.quickgroceries.product.model;

public class RequestDto {
	
	private String productName;
	
	private String productDescription;
	
	private String productShortName;
	
	public ListPrice listprice;
	
	

	public RequestDto() {
		super();
	}

	public RequestDto(String productName, String productDescription, String productShortName, ListPrice listprice) {
		super();
		this.productName = productName;
		this.productDescription = productDescription;
		this.productShortName = productShortName;
		this.listprice = listprice;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getProductShortName() {
		return productShortName;
	}

	public void setProductShortName(String productShortName) {
		this.productShortName = productShortName;
	}

	public ListPrice getListPrice() {
		return listprice;
	}

	public void setListPrice(ListPrice listprice) {
		this.listprice = listprice;
	}
	
	
	

}
