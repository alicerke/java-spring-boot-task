package hu.steve.transport.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hu.steve.transport.model.Section;
import hu.steve.transport.model.TransportPlan;
import hu.steve.transport.repository.SectionRepository;
import hu.steve.transport.repository.TransportPlanRepository;

@Service
public class TransportPlanService {

	private TransportPlanRepository transportPlanRepository;
	private SectionService sectionService;
	private SectionRepository sectionRepository;
	
	public TransportPlanService(TransportPlanRepository transportPlanRepository, SectionService sectionService,
			SectionRepository sectionRepository) {
		super();
		this.transportPlanRepository = transportPlanRepository;
		this.sectionService = sectionService;
		this.sectionRepository = sectionRepository;
		
	}

	@Transactional
	public TransportPlan save(TransportPlan transportPlan) {
		transportPlan.setId(null);
		return transportPlanRepository.save(transportPlan);
	}
	
	@Transactional
	public TransportPlan update(TransportPlan transportPlan) {
		if(!transportPlanRepository.existsById(transportPlan.getId()))
			return null;
		return transportPlanRepository.save(transportPlan);	
	}
	
	@Transactional
	public void delete(long id) {
		transportPlanRepository.deleteById(id);
	}
	
	public List<TransportPlan> getAll() {
		return transportPlanRepository.findAll();
	}
	
	public Optional<TransportPlan> getById(long id) {
		return transportPlanRepository.findById(id);
	}
	
	@Transactional
	public TransportPlan addSectiontoTransportPlan(long id, Section section) {
		TransportPlan transportPlan = transportPlanRepository.findById(id).get();
		transportPlan.addSection(section);
		sectionService.save(section);
		return transportPlan;
	}
	
	@Transactional
	public TransportPlan removeSecetionfromTransportPlan(long id, long sectionId) {
		TransportPlan transportPlan = transportPlanRepository.findById(id).get();
		Section section = sectionRepository.findById(sectionId).get();
		section.setTransportPlan(null);
		transportPlan.getSections().remove(section);
		return transportPlan;
	}
	
}
