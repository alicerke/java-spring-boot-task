package hu.steve.webshop.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


@Entity
@Table(name = "category")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long categoryId;
	
    private String name;
    
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Product> products;
    
    @CreationTimestamp
    @Column(name = "create_date")
    private LocalDateTime createDate;

    @UpdateTimestamp
    @Column(name = "modify_date")
    private LocalDateTime modifyDate;
    
    public Category() {
    }

	public Category(String name, List<Product> products, LocalDateTime createDate, LocalDateTime modifyDate) {
		super();
		this.name = name;
		this.products = products;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
	}

	public Category(Long categoryId, String name, List<Product> products, LocalDateTime createDate,
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
