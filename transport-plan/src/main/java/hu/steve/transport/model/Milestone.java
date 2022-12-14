package hu.steve.transport.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Milestone {

	@Id
    @GeneratedValue
    private Long id;
	
	private LocalDateTime plannedTime;
	
	@ManyToOne
	@JoinColumn(name = "address_id")
	private Address address;
	
	public Milestone() {
		super();
	}

	public Milestone(LocalDateTime plannedTime, Address address) {
		super();
		this.plannedTime = plannedTime;
		this.address = address;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getPlannedTime() {
		return plannedTime;
	}

	public void setPlannedTime(LocalDateTime plannedTime) {
		this.plannedTime = plannedTime;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
}
