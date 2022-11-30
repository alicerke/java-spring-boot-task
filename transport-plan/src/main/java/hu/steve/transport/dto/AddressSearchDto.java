package hu.steve.transport.dto;

public class AddressSearchDto {

	private String countryISO;
	private String zipcode;
	private String city;
	private String street;
	
	public AddressSearchDto() {
		super();
	}
	public AddressSearchDto(String countryISO, String zipcode, String city, String street) {
		super();
		this.countryISO = countryISO;
		this.zipcode = zipcode;
		this.city = city;
		this.street = street;
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
}
