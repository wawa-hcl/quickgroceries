package com.quickgroceries.product.model;

public class ResponseDto {
	
	private Long id;
	
	private String productName;
	
	private String productDescription;
	
	private String productShortName;
	
	public ListPrice listprice;

	public ResponseDto(Long id, String productName, String productDescription, String productShortName,
			ListPrice listprice) {
		super();
		this.id = id;
		this.productName = productName;
		this.productDescription = productDescription;
		this.productShortName = productShortName;
		this.listprice = listprice;
	}

	public ResponseDto() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public ListPrice getListprice() {
		return listprice;
	}

	public void setListprice(ListPrice listprice) {
		this.listprice = listprice;
	}
	
	

	
	
	
}
