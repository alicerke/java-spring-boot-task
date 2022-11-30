package hu.steve.transport.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Address {

	@Id
	@GeneratedValue
	private Long id;
	
	private String country;
	private String city;
	private String street;
	private String zipCode;
	private String houseNumber;	
	private String longitude;
	private String latitude;
	
	public Address() {
		
	}
	
	public Address(String country, String city, String street, String zipCode, String houseNumber,
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
	
	public Address(Long id, String country, String city, String street, String zipCode, String houseNumber,
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
