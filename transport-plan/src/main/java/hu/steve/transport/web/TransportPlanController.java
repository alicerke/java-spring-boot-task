package hu.steve.transport.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import hu.steve.transport.dto.DelayDto;
import hu.steve.transport.repository.SectionRepository;
import hu.steve.transport.repository.TransportPlanRepository;
import hu.steve.transport.service.DelayService;
import hu.steve.transport.service.IncomeMoneyService;
import hu.steve.transport.service.SectionService;

@RestController
@RequestMapping("/api/transportplans")
public class TransportPlanController {
	

	private TransportPlanRepository transportPlanRepository;
	private SectionRepository sectionRepository;
	private SectionService sectionService;
	private DelayService delayService;
	private IncomeMoneyService incomeMoneyService;
	
	public TransportPlanController( TransportPlanRepository transportPlanRepository, SectionRepository sectionRepository, 
			SectionService sectionService, DelayService delayService, IncomeMoneyService incomeMoneyService) {
		super();
		this.transportPlanRepository = transportPlanRepository;
		this.sectionRepository = sectionRepository;
		this.sectionService = sectionService;
		this.delayService = delayService;
		this.incomeMoneyService = incomeMoneyService;
	}
	
	
	@PostMapping("/{id}/delay")
	public void addDelayToTransportPlan(@PathVariable Long id, @RequestBody DelayDto delay) {
		if(transportPlanRepository.existsById(id) && sectionRepository.existsById(delay.getId())) {
			if(sectionService.checkMilestoneInSection(id, delay.getId())) {
				delayService.setMilestone(id, delay.getId(), delay.getDelay());
				incomeMoneyService.modifyIncomeMoney(id, delay.getDelay());
			} else { throw new ResponseStatusException(HttpStatus.BAD_REQUEST); }
		} else { throw new ResponseStatusException(HttpStatus.NOT_FOUND); }
	}
}
