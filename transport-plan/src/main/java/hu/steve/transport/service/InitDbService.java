package hu.steve.transport.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hu.steve.transport.model.Address;
import hu.steve.transport.model.Milestone;
import hu.steve.transport.model.Section;
import hu.steve.transport.model.TransportPlan;
import hu.steve.transport.repository.AddressRepository;
import hu.steve.transport.repository.MilestoneRepository;
import hu.steve.transport.repository.SectionRepository;
import hu.steve.transport.repository.TransportPlanRepository;

@Service
public class InitDbService {

	private AddressRepository addressRepository;
	private MilestoneRepository milestoneRepository;
	private SectionRepository sectionRepository;
	private TransportPlanRepository transportplanRepository;
	
	public InitDbService(AddressRepository addressRepository, MilestoneRepository milestoneRepository,
			SectionRepository sectionRepository,TransportPlanRepository transportplanRepository) {
		super();
		this.addressRepository = addressRepository;
		this.milestoneRepository = milestoneRepository;
		this.sectionRepository = sectionRepository;
		this.transportplanRepository = transportplanRepository;
	}

	@Transactional
	public void initDb() {
		Address address1 = addressRepository.save(new Address("HU", "1234", "Győr", "Paptagi utca", "52/B", null, null));
		Address address2 = addressRepository.save(new Address("HU", "5674", "Pécs", "Andrási utca", "123", null, null));
		Address address3 = addressRepository.save(new Address("HU", "8765", "Budapest", "Jókai utca", "82", null, null));
		Address address4 = addressRepository.save(new Address("HU", "2431", "Sopron", "Erdősor utca", "34", null, null));
		
		Milestone milestone1 = milestoneRepository.save(new Milestone(LocalDateTime.now(), address1));
		Milestone milestone2 = milestoneRepository.save(new Milestone(LocalDateTime.now().plusHours(3), address2));
		Milestone milestone3 = milestoneRepository.save(new Milestone(LocalDateTime.now().plusHours(4), address4));
		Milestone milestone4 = milestoneRepository.save(new Milestone(LocalDateTime.now().plusHours(8), address3));
		Milestone milestone5 = milestoneRepository.save(new Milestone(LocalDateTime.now().plusHours(1), address1));
		
		Section section1 = sectionRepository.save(new Section(milestone1, milestone2, null, 1));
		Section section2 = sectionRepository.save(new Section(milestone3, milestone4, null, 2));
		
		TransportPlan transportPlan1 = transportplanRepository.save(new TransportPlan());
		transportPlan1.addSection(section1);
		transportPlan1.addSection(section2);
		transportPlan1.setIncomeMoney(1000L);
	}
	
	@Transactional
	public void deleteAll() {	
		transportplanRepository.deleteAll();
		sectionRepository.deleteAll();
		milestoneRepository.deleteAll();
		addressRepository.deleteAll();
	}
}
