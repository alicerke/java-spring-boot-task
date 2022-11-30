package hu.webuni.hr.steve.service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.webuni.hr.steve.config.HrConfigProperties;
import hu.webuni.hr.steve.config.HrConfigProperties.Smart;
import hu.webuni.hr.steve.model.Employee;

@Service
public class SmartEmployeeService extends AbstractEmployeeService {
	
	@Autowired
	HrConfigProperties config;

	@Override
	public int getPayRaisePercent(Employee employee) {
		double yearsWorked = ChronoUnit.DAYS.between(employee.getDateOfStartWork(), LocalDateTime.now()) / 365.0;
		Smart smartConfig = config.getSalary().getSmart();		
		TreeMap<Double, Integer> limits = smartConfig.getLimits();	
		Entry<Double, Integer> floorEntry = limits.floorEntry(yearsWorked);
		return floorEntry == null ? 0 : floorEntry.getValue();
	}

}
