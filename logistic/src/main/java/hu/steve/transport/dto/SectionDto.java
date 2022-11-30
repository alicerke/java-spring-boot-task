package hu.steve.transport.dto;

import javax.validation.constraints.PositiveOrZero;

import hu.steve.transport.model.Milestone;

public class SectionDto {
	
	private Long id;
	
	@PositiveOrZero
	private Integer number;
	
	private Milestone fromMilestone;
	private Milestone toMilestone;
	
	public SectionDto() {
	}
	
	public SectionDto(Long id, Integer number, Milestone fromMilestone, Milestone toMilestone) {
		super();
		this.id = id;
		this.number = number;
		this.fromMilestone = fromMilestone;
		this.toMilestone = toMilestone;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public Milestone getFromMilestone() {
		return fromMilestone;
	}
	public void setFromMilestone(Milestone fromMilestone) {
		this.fromMilestone = fromMilestone;
	}
	public Milestone getToMilestone() {
		return toMilestone;
	}
	public void setToMilestone(Milestone toMilestone) {
		this.toMilestone = toMilestone;
	}
}
