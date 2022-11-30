package hu.steve.transport.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hu.steve.transport.model.Address;
import hu.steve.transport.model.Milestone;
import hu.steve.transport.repository.MilestoneRepository;

@Service
public class MilestoneService {

	@Autowired
	MilestoneRepository milestoneRepository;
	
	@Autowired
	AddressService addressService;
	
	@Transactional
	public Milestone save(Milestone milestone) {
		milestone.setId(null);
		return milestoneRepository.save(milestone);
	}
	
	@Transactional
	public Milestone update(Milestone section) {
		if(!milestoneRepository.existsById(section.getId()))
			return null;
		return milestoneRepository.save(section);
	}
	
	@Transactional
	public void delete(long id) {
		milestoneRepository.deleteById(id);
	}
	
	public List<Milestone> getAll(){
		return milestoneRepository.findAll();
	}
	
	public Optional<Milestone> getById(long id) {
		return milestoneRepository.findById(id);
	}
	
	@Transactional
	public Milestone addAddressToMilestone(long id, Address address) {
		Milestone milestone = milestoneRepository.findById(id).get();
		milestone.setAddress(address);
		addressService.save(address);
		return milestone;
	}
	
	@Transactional
	public Milestone replaceAddress(long id, Address address) {
		Milestone milestone = milestoneRepository.findById(id).get();
		milestone.setAddress(null);
		milestone.setAddress(address);
		addressService.save(address);
		return milestone;
	}
	
	@Transactional
	public Milestone removeAddress(long id) {
		Milestone milestone = milestoneRepository.findById(id).get();
		milestone.setAddress(null);
		return milestone;
	}
}
