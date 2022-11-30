package hu.steve.transport.service;

import org.springframework.data.jpa.domain.Specification;

import hu.steve.transport.model.Address;
import hu.steve.transport.model.Address_;

public class AddressSpecifications {
	public static Specification<Address> hasCountry(String countryISO){
		return (root, cq, cb) -> cb.equal(root.get(Address_.countryISO), countryISO);
	}
	
	public static Specification<Address> hasCity(String city){
		return (root, cq, cb) -> cb.like(cb.lower(root.get(Address_.city)), (city + "%").toLowerCase());
	}
	
	public static Specification<Address> hasStreet(String street){
		return (root, cq, cb) -> cb.like(cb.lower(root.get(Address_.street)), (street + "%").toLowerCase());
	}
	
	public static Specification<Address> hasZipCode(String zipcode){
		return (root, cq, cb) -> cb.equal(root.get(Address_.zipcode), zipcode);
	}
}
