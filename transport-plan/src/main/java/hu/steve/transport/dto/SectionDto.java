package hu.steve.transport.dto;

import hu.steve.transport.model.Milestone;
import hu.steve.transport.model.TransportPlan;

public class SectionDto {
	
    private Long id;
	private Milestone fromMilestone;
	private Milestone toMilestone;
	private TransportPlan transportplan;
	private Integer sectionNumber;
	
	public SectionDto() {
		super();
	}
	public SectionDto(Milestone fromMilestone, Milestone toMilestone, TransportPlan transportplan,
			Integer sectionNumber) {
		super();
		this.fromMilestone = fromMilestone;
		this.toMilestone = toMilestone;
		this.transportplan = transportplan;
		this.sectionNumber = sectionNumber;
	}
	public SectionDto(Long id, Milestone fromMilestone, Milestone toMilestone, TransportPlan transportplan,
			Integer sectionNumber) {
		super();
		this.id = id;
		this.fromMilestone = fromMilestone;
		this.toMilestone = toMilestone;
		this.transportplan = transportplan;
		this.sectionNumber = sectionNumber;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public TransportPlan getTransportplan() {
		return transportplan;
	}
	public void setTransportplan(TransportPlan transportplan) {
		this.transportplan = transportplan;
	}
	public Integer getSectionNumber() {
		return sectionNumber;
	}
	public void setSectionNumber(Integer sectionNumber) {
		this.sectionNumber = sectionNumber;
	}
}
