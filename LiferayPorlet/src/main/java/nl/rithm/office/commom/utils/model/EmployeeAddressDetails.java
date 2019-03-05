package nl.rithm.office.commom.utils.model;

import java.math.BigDecimal;

public class EmployeeAddressDetails {
	
	private BigDecimal addressId;
	private String country;
	private String city;
	private String streetName;
	private String houseNumber;
	private String zipCode;
	
	@Override
	public String toString() {
		return "EmployeeAddress [addressId=" + addressId + ", country=" + country + ", city=" + city + ", streetName="
				+ streetName + ", houseNumber=" + houseNumber + ", zipCode=" + zipCode + "]";
	}
	public BigDecimal getAddressId() {
		return addressId;
	}
	public void setAddressId(BigDecimal addressId) {
		this.addressId = addressId;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public String getHouseNumber() {
		return houseNumber;
	}
	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

}
