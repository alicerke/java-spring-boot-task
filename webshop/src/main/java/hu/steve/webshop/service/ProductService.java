package hu.steve.webshop.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import hu.steve.webshop.model.Product;
import hu.steve.webshop.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;
	
	public List<Product> getAllProduct(){		
		return productRepository.findAll();
	}
	
	public Optional<Product> getProductById(Long id){
		return productRepository.findById(id);
	}
	
	
	@Transactional
	public Product addNewProduct(Product product) {
		product.setProductId(null);
		return productRepository.save(product);
	}
	
	@Transactional
	public Product modifyProduct(Product product) {
		if(!productRepository.existsById(product.getProductId()))
			return null;
		return productRepository.save(product);
	}
	
	@Transactional
	public String removeProductById(Long id) {
		if(!productRepository.existsById(id))
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		productRepository.deleteById(id);
		return "Deleted product with id: " + id;
	}
	
	@Transactional
	public String removeAllProduct() {
		productRepository.deleteAll();
		return "Deleted all products.";
	}	
	
}
