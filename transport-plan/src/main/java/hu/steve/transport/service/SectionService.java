package hu.steve.transport.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hu.steve.transport.model.Section;
import hu.steve.transport.repository.SectionRepository;

@Service
public class SectionService {

	@Autowired
	SectionRepository sectionRepository;
	
	@Autowired
	MilestoneService milestoneService;
	
	
	@Transactional
	public Section save(Section section) {
		section.setId(null);
		return sectionRepository.save(section);
	}
	
	@Transactional
	public Section update(Section section) {
		if(!sectionRepository.existsById(section.getId()))
			return null;
		return sectionRepository.save(section);
	}
	
	@Transactional
	public void delete(long id) {
		sectionRepository.deleteById(id);
	}
	
	public List<Section> getAll(){
		return sectionRepository.findAll();
	}
	
	public Optional<Section> getById(long id) {
		return sectionRepository.findById(id);
	}
	
	public Boolean checkMilestoneInSection(Long transportplanId, Long milestoneId) {
		List<Section> sectionsWithMilestones = sectionRepository.findByTransportAndMilestoneId(transportplanId, milestoneId);
		return sectionsWithMilestones.isEmpty() ? false : true;
	}
	
	public Integer findMaxSectionById(Long transportplanId) {
		return sectionRepository.findMaxSectionById(transportplanId);
	}
	
	public Optional<Section> findByMilestoneId(Long milestoneId) {
		return sectionRepository.findByMilestoneId(milestoneId);
	}
	
	public Optional<Section> findBySectionNumber(Long transportplanId, Integer sectionNumber){
		return sectionRepository.findBySectionNumber(transportplanId, sectionNumber);
	}
	
}
