package hu.steve.transport.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	public Milestone update(Milestone milestone) {
		if(!milestoneRepository.existsById(milestone.getId()))
			return null;
		return milestoneRepository.save(milestone);
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
	
	public void increasePlannedTime(Long milestoneId, Integer delay) {
		Milestone milestone = milestoneRepository.findById(milestoneId).get();
		milestone.setPlannedTime(milestone.getPlannedTime().plusMinutes(delay));
	}
}
