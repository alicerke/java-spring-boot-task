package hu.steve.transport.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import hu.steve.transport.dto.AddressSearchDto;
import hu.steve.transport.model.Address;
import hu.steve.transport.repository.AddressRepository;


@Service
public class AddressService {

	@Autowired
	AddressRepository addressRepository;
	
	
	@Transactional
	public Address save(Address address) {
		address.setId(null);
		return addressRepository.save(address);
	}
	
	@Transactional
	public Address update(Address section) {
		if(!addressRepository.existsById(section.getId()))
			return null;
		return addressRepository.save(section);
	}
	
	@Transactional
	public void delete(long id) {
		addressRepository.deleteById(id);
	}
	
	public List<Address> getAll(){
		return addressRepository.findAll();
	}
	
	public Optional<Address> getById(long id) {
		return addressRepository.findById(id);
	}
	
	public Page<Address> findAddressByExample(AddressSearchDto address, Pageable pageable){
		
		String country = address.getCountryISO();
		String city = address.getCity();
		String street = address.getStreet();
		String zipCode = address.getZipcode();
		
		Specification<Address> spec = Specification.where(null);
		
		if(StringUtils.hasText(country))
			spec = spec.and(AddressSpecifications.hasCountry(country));
		if(StringUtils.hasText(city))
			spec = spec.and(AddressSpecifications.hasCity(city));
		if(StringUtils.hasText(street))
			spec = spec.and(AddressSpecifications.hasStreet(street));
		if(StringUtils.hasText(zipCode))
			spec = spec.and(AddressSpecifications.hasZipCode(zipCode));
		
		return addressRepository.findAll(spec, pageable);
	}	
}
