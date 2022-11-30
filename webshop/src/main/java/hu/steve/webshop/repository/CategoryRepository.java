package hu.steve.webshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import hu.steve.webshop.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

	Long countByNameAndCategoryIdNot(String name, Long id);

	Long countByName(String name);

}
