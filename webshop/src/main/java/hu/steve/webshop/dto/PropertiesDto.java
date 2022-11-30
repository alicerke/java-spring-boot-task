package hu.steve.webshop.dto;

public class PropertiesDto {

	private Long id;	
	private String weight;
	
	public PropertiesDto() {
		super();
	}
	public PropertiesDto(String weight) {
		super();
		this.weight = weight;
	}
	public PropertiesDto(Long id, String weight) {
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
