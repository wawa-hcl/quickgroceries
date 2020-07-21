package com.quickgroceries.customer.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Entity
@Table(name = "taddress")
public class AddressEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "uidpk_address")
	private long uidpk;
	
	@NotNull
	@Size(min=6,max=30, message="Addrss character must be greater than 6")
	@Column(name = "StreetAddress")
	private String streetAddress;
	@NotNull
	@Size(min=4,max=30, message="Locality name character must be greater than 4")
	@Column(name = "Locality")
	private String locality;
	@NotNull
	@Size(min=3,max=30, message="City name character must be greater than 3")
	@Column(name = "City")
	private String city;
	@NotNull
	@Size(min=3,max=30, message="State name character must be greater than 3")
	@Column(name = "State")
	private String state;
	@NotNull
	@Column(name = "Country")
	private String country;
	@Digits(fraction = 0, integer = 4) 
	@Column(name = "Pincode")
	private int pincode;
	
	
	public AddressEntity() {

	}

	public AddressEntity(long uidpk, String streetAddress, String locality, String city, String state, String country,
			int pincode) {
		super();
		this.uidpk = uidpk;
		this.streetAddress = streetAddress;
		this.locality = locality;
		this.city = city;
		this.state = state;
		this.country = country;
		this.pincode = pincode;
	}

	public long getUidpk() {
		return uidpk;
	}

	public void setUidpk(long uidpk) {
		this.uidpk = uidpk;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "AddressEntity [uidpk=" + uidpk + ", streetAddress=" + streetAddress + ", locality=" + locality
				+ ", city=" + city + ", state=" + state + ", country=" + country + ", pincode=" + pincode + "]";
	}

}
