package hu.steve.webshop.dto;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.constraints.NotBlank;

import hu.steve.webshop.model.Product;

public class CategoryDto {

	private Long categoryId;
	
	@NotBlank
    private String name;
	
    private List<Product> products;
    private LocalDateTime createDate;
    private LocalDateTime modifyDate;
    
    public CategoryDto() {
    }

	public CategoryDto(@NotBlank String name, List<Product> products, LocalDateTime createDate,
			LocalDateTime modifyDate) {
		super();
		this.name = name;
		this.products = products;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
	}

	public CategoryDto(Long categoryId, String name, List<Product> products, LocalDateTime createDate,
			LocalDateTime modifyDate) {
		super();
		this.categoryId = categoryId;
		this.name = name;
		this.products = products;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public LocalDateTime getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}

	public LocalDateTime getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(LocalDateTime modifyDate) {
		this.modifyDate = modifyDate;
	}
}
