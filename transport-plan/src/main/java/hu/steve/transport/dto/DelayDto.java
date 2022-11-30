package hu.steve.transport.dto;

public class DelayDto {

	private Long id;
	private Integer delay;
	
	public DelayDto() {
		super();
	}
	public DelayDto(Long id, Integer delay) {
		super();
		this.id = id;
		this.delay = delay;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getDelay() {
		return delay;
	}
	public void setDelay(Integer delay) {
		this.delay = delay;
	}
	
	
}
