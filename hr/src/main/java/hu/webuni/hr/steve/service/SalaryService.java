package hu.webuni.hr.steve.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hu.webuni.hr.steve.model.Employee;
import hu.webuni.hr.steve.repository.EmployeeRepository;

@Service
public class SalaryService {
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	

	public void setNewSalary(Employee employee) {
		int newSalary = employee.getSalary() * (100 + employeeService.getPayRaisePercent(employee)) / 100;
		employee.setSalary(newSalary);
	}

	@Transactional
	public void raiseMinSalary(long companyId, String positionName, int minSalary) {
		
		employeeRepository.updateSalaries(positionName, minSalary, companyId);	
	}

}
