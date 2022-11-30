package hu.steve.webshop.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import hu.steve.webshop.dto.ProductDto;
import hu.steve.webshop.mapper.ProductMapper;
import hu.steve.webshop.model.Product;
import hu.steve.webshop.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	private ProductMapper productMapper;
	private ProductService productService;
	
	public ProductController(ProductMapper productMapper, ProductService productService) {
		super();
		this.productMapper = productMapper;
		this.productService = productService;
	}

	@GetMapping
	public List<ProductDto> getAllProductDto() {
		return productMapper.productListToDto(productService.getAllProduct());
	}
	
	@GetMapping("/{id}")
	public ProductDto getProductDtoById(@PathVariable long id){
		Product product = productService.getProductById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
		return productMapper.productToDto(product);
	}
	
	@PostMapping
	public ProductDto addNewProductDto(@RequestBody @Valid ProductDto productDto) {
		return productMapper.productToDto(productService.addNewProduct(productMapper.dtoToProduct(productDto)));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ProductDto> modifyProductDto(@PathVariable Long id, @RequestBody @Valid ProductDto productDto) {
		productDto.setProductId(id);
		Product updateProduct = productService.modifyProduct(productMapper.dtoToProduct(productDto));
		return updateProduct == null 
				? ResponseEntity.notFound().build()
				: ResponseEntity.ok(productMapper.productToDto(updateProduct));
	}
	
	@DeleteMapping("/{id}")
	public String removeProductById(@PathVariable long id) {
		return productService.removeProductById(id);
	}	
}
