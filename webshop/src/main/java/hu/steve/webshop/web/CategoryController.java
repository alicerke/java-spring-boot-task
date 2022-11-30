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

import hu.steve.webshop.dto.CategoryDto;
import hu.steve.webshop.mapper.CategoryMapper;
import hu.steve.webshop.model.Category;
import hu.steve.webshop.service.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

	private CategoryService categoryService;
	private CategoryMapper categoryMapper;

	public CategoryController(CategoryService categoryService, CategoryMapper categoryMapper) {
		super();
		this.categoryService = categoryService;
		this.categoryMapper = categoryMapper;
	}

	@GetMapping
	public List<CategoryDto> getAllCategoryDto() {
		return categoryMapper.categoryListToDto(categoryService.getAllCategory());
	}
	
	@GetMapping("/{id}")
	public CategoryDto getCategoryDtoById(@PathVariable long id){
		Category category = categoryService.getCategoryById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
		return categoryMapper.categoryToDto(category);
	}
	
	@PostMapping
	public CategoryDto addNewCategoryDto(@RequestBody @Valid CategoryDto categoryDto) {
		return categoryMapper.categoryToDto(categoryService.addNewCategory(categoryMapper.dtoToCategory(categoryDto)));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<CategoryDto> modifyCategoryDto(@PathVariable Long id, @RequestBody @Valid CategoryDto categoryDto) {
		categoryDto.setCategoryId(id);
		Category updateCategory = categoryService.modifyCategory(categoryMapper.dtoToCategory(categoryDto));
		return updateCategory == null 
				? ResponseEntity.notFound().build()
				: ResponseEntity.ok(categoryMapper.categoryToDto(updateCategory));
	}
	
	@DeleteMapping("/{id}")
	public String removeCategoryById(@PathVariable long id) {
		return categoryService.removeCategoryById(id);
	}
	
}
