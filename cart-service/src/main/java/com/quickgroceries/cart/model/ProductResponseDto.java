package com.quickgroceries.cart.model;

/**
 * The Class ProductResponseDto.
 */
public class ProductResponseDto {

	/** The id. */
	private Long id;

	/** The product name. */
	private String productName;

	/** The product description. */
	private String productDescription;

	/** The product short name. */
	private String productShortName;

	/** The listprice. */
	private ListPrice listprice;

	/**
	 * Instantiates a new product response dto.
	 *
	 * @param id                 the id
	 * @param productName        the product name
	 * @param productDescription the product description
	 * @param productShortName   the product short name
	 * @param listprice          the listprice
	 */
	public ProductResponseDto(Long id, String productName, String productDescription, String productShortName,
			ListPrice listprice) {
		super();
		this.id = id;
		this.productName = productName;
		this.productDescription = productDescription;
		this.productShortName = productShortName;
		this.listprice = listprice;
	}

	/**
	 * Instantiates a new product response dto.
	 */
	public ProductResponseDto() {
		super();
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Long id) {
		this.id = id;
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
	 * Gets the listprice.
	 *
	 * @return the listprice
	 */
	public ListPrice getListprice() {
		return listprice;
	}

	/**
	 * Sets the listprice.
	 *
	 * @param listprice the new listprice
	 */
	public void setListprice(ListPrice listprice) {
		this.listprice = listprice;
	}

}
