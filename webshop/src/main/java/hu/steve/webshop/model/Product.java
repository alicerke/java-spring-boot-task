package hu.steve.webshop.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


@Entity
@Table(name = "product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long productId;
	
    private String name;
    private String description;
    private Double price;
    private String unit;
    private String brand;
    private String image;
    private Integer quantity;
    private Boolean active;
    private Boolean isFeatured;
    
    @OneToOne
    private Properties properties;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Category> categories;

    @CreationTimestamp
    @Column(name = "create_date")
    private LocalDateTime createDate;

    @UpdateTimestamp
    @Column(name = "modify_date")
    private LocalDateTime modifyDate;

    public Product() {
    }

	public Product(String name, String description, Double price, String unit, String brand, String image,
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

	public Product(Long productId, String name, String description, Double price, String unit, String brand,
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
	
	public void addCategory(Category category) {
		if(this.categories == null)
			this.categories = new ArrayList<>();
		this.categories.add(category);
		category.getProducts().add(this);
	}
}
