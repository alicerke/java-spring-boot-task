package hu.steve.transport.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedSubgraph;
import javax.persistence.OneToMany;

@NamedEntityGraph(
		name = "TransportPlan-full", 
		attributeNodes = { 
			@NamedAttributeNode(value = "sections", subgraph = "sectioins-subgraph"), 
		},
		subgraphs = {
			@NamedSubgraph(
				name = "sectioins-subgraph",
				attributeNodes = { @NamedAttributeNode(value = "fromMilestone", subgraph="address-subgraph") }
			),
			@NamedSubgraph(
				name = "sectioins-subgraph",
				attributeNodes = { @NamedAttributeNode(value = "toMilestone", subgraph="address-subgraph") }
			),
			@NamedSubgraph(
				name = "address-subgraph",
				attributeNodes = { @NamedAttributeNode("address") }
			)
		}
	)
@Entity
public class TransportPlan {

	@Id
	@GeneratedValue
	private Long id;
	
	private Long incomeMoney;
	
	@OneToMany(mappedBy="transportplan")
	private List<Section> sections;
	
	public TransportPlan() {
		super();
	}

	public TransportPlan(Long incomeMoney, List<Section> sections) {
		super();
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
	
	public void addSection(Section section) {
		if(this.sections == null)
			this.sections = new ArrayList<>();
		this.sections.add(section);
		section.setTransportplan(this);
	}
}
