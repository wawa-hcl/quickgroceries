package com.quickgroceries.product.model;

/**
 * The Class RequestDto.
 */
public class RequestDto {

	/** The product name. */
	private String productName;

	/** The product description. */
	private String productDescription;

	/** The product short name. */
	private String productShortName;

	/** The listprice. */
	private ListPrice listprice;

	/**
	 * Instantiates a new request dto.
	 */
	public RequestDto() {
		super();
	}

	/**
	 * Instantiates a new request dto.
	 *
	 * @param productName        the product name
	 * @param productDescription the product description
	 * @param productShortName   the product short name
	 * @param listprice          the listprice
	 */
	public RequestDto(String productName, String productDescription, String productShortName, ListPrice listprice) {
		super();
		this.productName = productName;
		this.productDescription = productDescription;
		this.productShortName = productShortName;
		this.listprice = listprice;
	}

	/**
	 * Gets the product name.
	 *
	 * @return the product name
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * Sets the product name.
	 *
	 * @param productName the new product name
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * Gets the product description.
	 *
	 * @return the product description
	 */
	public String getProductDescription() {
		return productDescription;
	}

	/**
	 * Sets the product description.
	 *
	 * @param productDescription the new product description
	 */
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	/**
	 * Gets the product short name.
	 *
	 * @return the product short name
	 */
	public String getProductShortName() {
		return productShortName;
	}

	/**
	 * Sets the product short name.
	 *
	 * @param productShortName the new product short name
	 */
	public void setProductShortName(String productShortName) {
		this.productShortName = productShortName;
	}

	/**
	 * Gets the list price.
	 *
	 * @return the list price
	 */
	public ListPrice getListPrice() {
		return listprice;
	}

	/**
	 * Sets the list price.
	 *
	 * @param listprice the new list price
	 */
	public void setListPrice(ListPrice listprice) {
		this.listprice = listprice;
	}

}
