package hu.steve.webshop.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import hu.steve.webshop.dto.CategoryDto;
import hu.steve.webshop.model.Category;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

	List<CategoryDto> categoryListToDto(List<Category> allCategory);

	CategoryDto categoryToDto(Category category);

	Category dtoToCategory(CategoryDto categoryDto);

}
