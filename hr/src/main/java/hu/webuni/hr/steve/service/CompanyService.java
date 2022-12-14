package hu.webuni.hr.steve.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hu.webuni.hr.steve.model.Company;
import hu.webuni.hr.steve.model.Employee;
import hu.webuni.hr.steve.repository.CompanyRepository;
import hu.webuni.hr.steve.repository.EmployeeRepository;

@Service
public class CompanyService {
	
	@Autowired
	private CompanyRepository companyRepository;
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private EmployeeService employeeService;
	
	@Transactional
	public Company save(Company company) {
		company.setId(null);
		return companyRepository.save(company);
	}

	@Transactional
	public Company update(Company company) {
		if(!companyRepository.existsById(company.getId()))
			return null;
		return companyRepository.save(company);
	}

	public List<Company> findAll() {
		return companyRepository.findAll();
	}

	public Optional<Company> findById(long id) {
		return companyRepository.findById(id);
	}

	public void delete(long id) {
		companyRepository.deleteById(id);
	}
	
	@Transactional
	public Company addEmployee(long id, Employee employee) {
		Company company = companyRepository.findByIdWithEmployees(id).get();
		company.addEmployee(employee);
		employeeService.save(employee);
		return company;
	}
	
	@Transactional
	public Company deleteEmployee(long id, long employeeId) {
		Company company = companyRepository.findById(id).get();
		Employee employee = employeeRepository.findById(employeeId).get();
		employee.setCompany(null);
		company.getEmployees().remove(employee);
		return company;
	}
	
	@Transactional
	public Company replaceEmployees(long id, List<Employee> employees) {
		Company company = companyRepository.findById(id).get();
		for (Employee employee : company.getEmployees()) {
			employee.setCompany(null);
		}
		company.getEmployees().clear();
		for (Employee employee : employees) {
			company.addEmployee(employee);
			employeeService.save(employee);
		}
		return company;
	}
	
}
