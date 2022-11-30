package hu.steve.webshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import hu.steve.webshop.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
