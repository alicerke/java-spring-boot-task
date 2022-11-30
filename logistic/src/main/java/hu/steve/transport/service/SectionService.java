package hu.steve.transport.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hu.steve.transport.model.Milestone;
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
	
	@Transactional
	public Section addFromMilestoneToSection(long id, Milestone milestone) {
		Section section = sectionRepository.findById(id).get();
		section.setFromMilestone(milestone);
		milestoneService.save(milestone);
		return section;
	}
	
	@Transactional
	public Section addToMilestoneToSection(long id, Milestone milestone) {
		Section section = sectionRepository.findById(id).get();
		section.setToMilestone(milestone);
		milestoneService.save(milestone);
		return section;
	}
	
	@Transactional
	public Section modifyFromMilestone(long id, Milestone milestone) {
		Section section = sectionRepository.findById(id).get();
		section.setFromMilestone(null);
		section.setFromMilestone(milestone);
		milestoneService.save(milestone);
		return section;
	}
	
	@Transactional
	public Section modifyToMilestone(long id, Milestone milestone) {
		Section section = sectionRepository.findById(id).get();
		section.setToMilestone(null);
		section.setToMilestone(milestone);
		milestoneService.save(milestone);
		return section;
	}
	
	@Transactional
	public Section removeFromMilestone(long id) {
		Section section = sectionRepository.findById(id).get();
		section.setFromMilestone(null);
		return section;
	}
	
	@Transactional
	public Section removeToMilestone(long id) {
		Section section = sectionRepository.findById(id).get();
		section.setToMilestone(null);
		return section;
	}
	
	
}
