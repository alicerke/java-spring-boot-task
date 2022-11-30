package hu.steve.webshop.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import hu.steve.webshop.model.Category;
import hu.steve.webshop.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	CategoryRepository categoryRepository;
	
	public List<Category> getAllCategory(){		
		return categoryRepository.findAll();
	}
	
	public Optional<Category> getCategoryById(Long id){
		return categoryRepository.findById(id);
	}
	
	public void checkUniqueCategoryName(String name, Long id) {
		boolean forUpdate = id != null;
		Long count = forUpdate ? categoryRepository.countByNameAndCategoryIdNot(name, id)
				: categoryRepository.countByName(name);
		if(count > 0)
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
	}
	
	@Transactional
	public Category addNewCategory(Category category) {
		category.setCategoryId(null);
		checkUniqueCategoryName(category.getName(), null);
		return categoryRepository.save(category);
	}
	
	@Transactional
	public Category modifyCategory(Category category) {
		checkUniqueCategoryName(category.getName(), category.getCategoryId());
		if(!categoryRepository.existsById(category.getCategoryId()))
			return null;
		return categoryRepository.save(category);
	}
	
	@Transactional
	public String removeCategoryById(Long id) {
		if(!categoryRepository.existsById(id))
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		categoryRepository.deleteById(id);
		return "Deleted category with id: " + id;
	}
	
	@Transactional
	public String removeAllCategory() {
		categoryRepository.deleteAll();
		return "Deleted all categories.";
	}
}
