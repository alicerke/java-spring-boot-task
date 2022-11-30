package hu.steve.transport.dto;

import java.time.LocalDateTime;

import hu.steve.transport.model.Address;

public class MilestoneDto {

	private Long id;
	private Address address;
	private LocalDateTime plannedTime;
	
	public MilestoneDto() {
	}
	
	public MilestoneDto(Address address, LocalDateTime plannedTime) {
		super();
		this.address = address;
		this.plannedTime = plannedTime;
	}

	public MilestoneDto(Long id, Address address, LocalDateTime plannedTime) {
		super();
		this.id = id;
		this.address = address;
		this.plannedTime = plannedTime;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public LocalDateTime getPlannedTime() {
		return plannedTime;
	}
	public void setPlannedTime(LocalDateTime plannedTime) {
		this.plannedTime = plannedTime;
	}
	
	
}
