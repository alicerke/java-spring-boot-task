package hu.steve.transport.service;

import java.util.TreeMap;
import java.util.Map.Entry;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.steve.transport.config.DelayConfigProperties;
import hu.steve.transport.model.TransportPlan;

@Service
public class IncomeMoneyService {
	
	@Autowired
	TransportPlanService transportPlanService;
	
	@Autowired
	DelayConfigProperties config;

	@Transactional
	public void modifyIncomeMoney(Long transportplanId, Integer delay) {
		TransportPlan transportPlan = transportPlanService.getById(transportplanId).get();
		Long currentIncomeMoney = transportPlan.getIncomeMoney();
		Long newIncomeMoney = (currentIncomeMoney * (100 - getDeclinePercentage(delay))) / 100;				
		transportPlan.setIncomeMoney(newIncomeMoney);
	}
	
	private long getDeclinePercentage(int delay) {
		TreeMap<Integer, Integer> limits = config.getDeclinePercentage().getLimits();
		Entry<Integer, Integer> floorEntry = limits.floorEntry(delay);		
		return floorEntry == null ? 0 : floorEntry.getValue();
	}
}
