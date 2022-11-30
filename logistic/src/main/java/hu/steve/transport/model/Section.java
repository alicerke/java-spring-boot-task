package hu.steve.transport.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Section {

	@Id
	@GeneratedValue
	private Long id;

	private Integer number;

	@OneToOne
	private Milestone fromMilestone;

	@OneToOne
	private Milestone toMilestone;

	@ManyToOne
	private TransportPlan transportPlan;

	public Section() {
	}
	
	public Section(Integer number, Milestone fromMilestone, Milestone toMilestone, TransportPlan transportPlan) {
		super();
		this.number = number;
		this.fromMilestone = fromMilestone;
		this.toMilestone = toMilestone;
		this.transportPlan = transportPlan;
	}

	public Section(Long id, Integer number, Milestone fromMilestone, Milestone toMilestone, TransportPlan transportPlan) {
		super();
		this.id = id;
		this.number = number;
		this.fromMilestone = fromMilestone;
		this.toMilestone = toMilestone;
		this.transportPlan = transportPlan;
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

	public TransportPlan getTransportPlan() {
		return transportPlan;
	}

	public void setTransportPlan(TransportPlan transportPlan) {
		this.transportPlan = transportPlan;
	}

}
