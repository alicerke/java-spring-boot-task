package hu.steve.webshop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String country;
	private String city;
	private String zipcode;
	private String Street;
	private String houseNumber;
	
	public Address() {
		super();
	}
	public Address(String country, String city, String zipcode, String street, String houseNumber) {
		super();
		this.country = country;
		this.city = city;
		this.zipcode = zipcode;
		Street = street;
		this.houseNumber = houseNumber;
	}
	public Address(Long id, String country, String city, String zipcode, String street, String houseNumber) {
		super();
		this.id = id;
		this.country = country;
		this.city = city;
		this.zipcode = zipcode;
		Street = street;
		this.houseNumber = houseNumber;
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
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getStreet() {
		return Street;
	}
	public void setStreet(String street) {
		Street = street;
	}
	public String getHouseNumber() {
		return houseNumber;
	}
	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}
}
