package hu.steve.transport.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Address {

	@Id
	@GeneratedValue
	private Long id;
	
	private String countryISO;
	private String zipcode;
	private String city;
	private String street;
	private String houseNumber;
	private String latitude;
	private String longitude;
	
	public Address() {
		super();
	}
	
	public Address(String countryISO, String zipcode, String city, String street, String houseNumber, String latitude,
			String longitude) {
		super();
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
