package hu.steve.transport.service;

import org.springframework.stereotype.Service;

import hu.steve.transport.model.Section;

@Service
public class DelayService {
	
	private SectionService sectionService;
	private MilestoneService milestoneService;
	
	public DelayService(SectionService sectionService, MilestoneService milestoneService) {
		super();
		this.sectionService = sectionService;
		this.milestoneService = milestoneService;
	}

	public void setMilestone(Long transportplanId, Long milestoneId, Integer delay) {
		Long fromMilestoneId = null;
		Long toMilestoneId = null;	
		Integer maxSectionNumber = sectionService.findMaxSectionById(transportplanId);
		Section section = sectionService.findByMilestoneId(milestoneId).get();
		
		if(section.getFromMilestone().getId() == milestoneId) {
			fromMilestoneId = milestoneId;
			toMilestoneId = section.getToMilestone().getId();			
		}
		
		if(section.getToMilestone().getId() == milestoneId) {
			if(section.getSectionNumber() < maxSectionNumber) {
				Integer nextSectionNumber = section.getSectionNumber() + 1;
				Section nextSection = sectionService.findBySectionNumber(transportplanId, nextSectionNumber).get();
				fromMilestoneId = milestoneId;
				toMilestoneId = nextSection.getFromMilestone().getId();
			} else {
				fromMilestoneId = null;
				toMilestoneId = milestoneId;			
			}
		}
		
		if(toMilestoneId != null)
			milestoneService.increasePlannedTime(toMilestoneId, delay);
		if(fromMilestoneId != null)
			milestoneService.increasePlannedTime(fromMilestoneId, delay);	
	}
}
