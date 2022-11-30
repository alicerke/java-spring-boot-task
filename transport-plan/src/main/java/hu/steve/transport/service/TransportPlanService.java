package hu.steve.transport.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hu.steve.transport.model.TransportPlan;
import hu.steve.transport.repository.TransportPlanRepository;

@Service
public class TransportPlanService {
	
	@Autowired
	TransportPlanRepository transportPlanRepository;

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
	
	
}
