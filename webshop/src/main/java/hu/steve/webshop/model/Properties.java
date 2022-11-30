package hu.steve.webshop.model;

import javax.persistence.*;

@Entity
public class Properties {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String weight;
	
	public Properties() {
		super();
	}

	public Properties(String weight) {
		super();
		this.weight = weight;
	}

	public Properties(Long id, String weight) {
		super();
		this.id = id;
		this.weight = weight;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}
}
