package hu.steve.transport.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AddressDto {
	
	private Long id;
	
	@NotNull
	@Size(min = 1)
	private String country;
	
	@NotNull
	@Size(min = 1)
	private String city;
	
	@NotNull
	@Size(min = 1)
	private String street;
	
	@NotNull
	@Size(min = 1)
	private String zipCode;
	
	@NotNull
	@Size(min = 1)
	private String houseNumber;	
	
	private String longitude;
	private String latitude;
	
	public AddressDto() {
	}
	
	public AddressDto(String country, String city, String street, String zipCode, String houseNumber,
			String longitude, String latitude) {
		super();
		this.country = country;
		this.city = city;
		this.street = street;
		this.zipCode = zipCode;
		this.houseNumber = houseNumber;
		this.longitude = longitude;
		this.latitude = latitude;
	}
	
	public AddressDto(Long id, String country, String city, String street, String zipCode, String houseNumber,
			String longitude, String latitude) {
		super();
		this.id = id;
		this.country = country;
		this.city = city;
		this.street = street;
		this.zipCode = zipCode;
		this.houseNumber = houseNumber;
		this.longitude = longitude;
		this.latitude = latitude;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getHouseNumber() {
		return houseNumber;
	}
	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
}
