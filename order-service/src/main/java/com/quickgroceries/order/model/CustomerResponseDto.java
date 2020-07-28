package com.quickgroceries.order.model;



public class CustomerResponseDto {
	private String firstname;
	private String lastname;
	private String customerpreference;
	private String email;
	private String username;
	private AddressDto address;
	private WalletResponseDto walletDetails;
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getCustomerpreference() {
		return customerpreference;
	}
	public void setCustomerpreference(String customerpreference) {
		this.customerpreference = customerpreference;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public AddressDto getAddress() {
		return address;
	}
	public void setAddress(AddressDto address) {
		this.address = address;
	}
	public WalletResponseDto getWalletDetails() {
		return walletDetails;
	}
	public void setWalletDetails(WalletResponseDto walletDetails) {
		this.walletDetails = walletDetails;
	}
	
}
	
