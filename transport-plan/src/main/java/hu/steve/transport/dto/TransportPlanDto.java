package hu.steve.transport.dto;

import java.util.List;

import hu.steve.transport.model.Section;

public class TransportPlanDto {

	private Long id;	
	private Long incomeMoney;
	private List<Section> sections;
	
	public TransportPlanDto() {
		super();
	}
	public TransportPlanDto(Long incomeMoney, List<Section> sections) {
		super();
		this.incomeMoney = incomeMoney;
		this.sections = sections;
	}
	public TransportPlanDto(Long id, Long incomeMoney, List<Section> sections) {
		super();
		this.id = id;
		this.incomeMoney = incomeMoney;
		this.sections = sections;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getIncomeMoney() {
		return incomeMoney;
	}
	public void setIncomeMoney(Long incomeMoney) {
		this.incomeMoney = incomeMoney;
	}
	public List<Section> getSections() {
		return sections;
	}
	public void setSections(List<Section> sections) {
		this.sections = sections;
	}
}
