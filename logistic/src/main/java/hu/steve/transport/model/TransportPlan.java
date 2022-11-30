package hu.steve.transport.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class TransportPlan {

	@Id
	@GeneratedValue
	private Long id;
	
	private Integer incomingMoney;
	
	@OneToMany(mappedBy = "transportplan")
	private List<Section> sections;
	
	public TransportPlan() {
		super();
	}

	public TransportPlan(Integer incomingMoney, List<Section> sections) {
		super();
		this.incomingMoney = incomingMoney;
		this.sections = sections;
	}

	public TransportPlan(Long id, Integer incomingMoney, List<Section> sections) {
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
	
	public void addSection(Section section) {
		if(this.sections == null)
			this.sections = new ArrayList<>();
		this.sections.add(section);	
		section.setTransportPlan(this);
	}
}
