package hu.steve.transport.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AddressDto {
	
	private Long id;
	
	@NotBlank
	@Size(min = 2, max = 2)	
	private String countryISO;
	@NotBlank
	private String zipcode;
	@NotBlank
	private String city;
	@NotBlank
	private String street;
	@NotBlank
	private String houseNumber;
	
	private String latitude;
	private String longitude;

	public AddressDto() {
		super();
	}
	
	public AddressDto(String countryISO,String zipcode, String city,String street, 
			String houseNumber, String latitude, String longitude) {
		super();
		this.countryISO = countryISO;
		this.zipcode = zipcode;
		this.city = city;
		this.street = street;
		this.houseNumber = houseNumber;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public AddressDto(Long id, String countryISO, String zipcode, String city, 
			String street, String houseNumber, String latitude, String longitude) {
		super();
		this.id = id;
		this.countryISO = countryISO;
		this.zipcode = zipcode;
		this.city = city;
		this.street = street;
		this.houseNumber = houseNumber;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCountryISO() {
		return countryISO;
	}
	public void setCountryISO(String countryISO) {
		this.countryISO = countryISO;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
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
	public String getHouseNumber() {
		return houseNumber;
	}
	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
}
