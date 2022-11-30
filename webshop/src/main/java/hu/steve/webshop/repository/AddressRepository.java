package hu.steve.webshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import hu.steve.webshop.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{

}
