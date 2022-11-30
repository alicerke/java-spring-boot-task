package hu.steve.webshop.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import hu.steve.webshop.dto.ProductDto;
import hu.steve.webshop.model.Product;

@Mapper(componentModel = "spring")
public interface ProductMapper {

	List<ProductDto> productListToDto(List<Product> allProduct);

	ProductDto productToDto(Product product);

	Product dtoToProduct(ProductDto productDto);

}
