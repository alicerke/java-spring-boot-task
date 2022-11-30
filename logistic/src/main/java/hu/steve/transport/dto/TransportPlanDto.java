package hu.steve.transport.dto;

import java.util.List;

import hu.steve.transport.model.Section;

public class TransportPlanDto {

	private Long id;	
	private Integer incomingMoney;
	private List<Section> sections;
	
	public TransportPlanDto() {
		super();
	}
	
	public TransportPlanDto(Integer incomingMoney, List<Section> sections) {
		super();
		this.incomingMoney = incomingMoney;
		this.sections = sections;
	}

	public TransportPlanDto(Long id, Integer incomingMoney, List<Section> sections) {
		super();
		this.id = id;
		this.incomingMoney = incomingMoney;
		this.sections = sections;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getIncomingMoney() {
		return incomingMoney;
	}
	public void setIncomingMoney(Integer incomingMoney) {
		this.incomingMoney = incomingMoney;
	}
	public List<Section> getSections() {
		return sections;
	}
	public void setSections(List<Section> sections) {
		this.sections = sections;
	}	
}
