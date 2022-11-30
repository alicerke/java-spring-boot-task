package hu.steve.transport.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Section {

	@Id
    @GeneratedValue
    private Long id;
	
	@OneToOne
	private Milestone fromMilestone;
	
	@OneToOne
	private Milestone toMilestone;
	
	@ManyToOne
	@JoinColumn(name = "transportplan_id")
	private TransportPlan transportplan;
	
	private Integer sectionNumber;
	
	public Section() {
		super();
	}

	public Section(Milestone fromMilestone, Milestone toMilestone, TransportPlan transportplan, Integer sectionNumber) {
		super();
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
