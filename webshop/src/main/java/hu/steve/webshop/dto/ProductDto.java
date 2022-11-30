package hu.steve.webshop.dto;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import hu.steve.webshop.model.Category;
import hu.steve.webshop.model.Properties;

public class ProductDto {

	private Long productId;
	
	@NotBlank
    private String name;
	
	@NotBlank
    private String description;

	@Positive
    private Double price;
	
    private String unit;
    private String brand;
    private String image;
    private Integer quantity;
    private Boolean active;
    private Boolean isFeatured;
    
    private Properties properties;

    private List<Category> categories;
    private LocalDateTime createDate;
    private LocalDateTime modifyDate;

    public ProductDto() {
    }

	public ProductDto(String name, String description, Double price, String unit, String brand, String image,
			Integer quantity, Boolean active, Boolean isFeatured, Properties properties, List<Category> categories, 
			LocalDateTime createDate, LocalDateTime modifyDate) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.unit = unit;
		this.brand = brand;
		this.image = image;
		this.quantity = quantity;
		this.active = active;
		this.isFeatured = isFeatured;
		this.properties = properties;
		this.categories = categories;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
	}

	public ProductDto(Long productId, String name, String description, Double price, String unit, String brand,
			String image, Integer quantity, Boolean active, Boolean isFeatured, Properties properties, 
			List<Category> categories, LocalDateTime createDate, LocalDateTime modifyDate) {
		super();
		this.productId = productId;
		this.name = name;
		this.description = description;
		this.price = price;
		this.unit = unit;
		this.brand = brand;
		this.image = image;
		this.quantity = quantity;
		this.active = active;
		this.isFeatured = isFeatured;
		this.properties = properties;
		this.categories = categories;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Boolean getIsFeatured() {
		return isFeatured;
	}

	public void setIsFeatured(Boolean isFeatured) {
		this.isFeatured = isFeatured;
	}

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
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
