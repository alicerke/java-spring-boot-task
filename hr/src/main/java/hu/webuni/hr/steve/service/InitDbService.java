package hu.webuni.hr.steve.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hu.webuni.hr.steve.model.Company;
import hu.webuni.hr.steve.model.Employee;
import hu.webuni.hr.steve.model.Position;
import hu.webuni.hr.steve.model.PositionDetailsByCompany;
import hu.webuni.hr.steve.model.Qualification;
import hu.webuni.hr.steve.repository.CompanyRepository;
import hu.webuni.hr.steve.repository.EmployeeRepository;
import hu.webuni.hr.steve.repository.PositionDetailsByCompanyRepository;
import hu.webuni.hr.steve.repository.PositionRepository;

@Service
public class InitDbService {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	CompanyRepository companyRepository;
	
	@Autowired
	PositionRepository positionRepository;
	
	@Autowired
	PositionDetailsByCompanyRepository positionDetailsByCompanyRepository;
	
	public void clearDB() {
		employeeRepository.deleteAll();
		companyRepository.deleteAll();
	}
	
	@Transactional
	public void insertTestData() {
		
		Position developer = positionRepository.save(new Position("developer", Qualification.UNIVERSITY));
		Position tester = positionRepository.save(new Position("tester", Qualification.HIGH_SCHOOL));
		
		Employee newEmployee1 = employeeRepository.save(new Employee(null, "Elek", /*"tesztelő",*/ 300, LocalDateTime.now()));
		newEmployee1.setPosition(tester);
		
		Employee newEmployee2 = employeeRepository.save(new Employee(null, "József", /*"tesztelő",*/ 250, LocalDateTime.now()));
		newEmployee2.setPosition(tester);
		
		Employee newEmployee3 = employeeRepository.save(new Employee(null, "Adrián", /*"fejlesztő",*/ 450, LocalDateTime.now()));
		newEmployee3.setPosition(developer);
		
		Company newCompany = companyRepository.save(new Company(null, 10, "Teszt Kft.", "1021 Budapest, Teszt u. 1.", null));
		newCompany.addEmployee(newEmployee1);
		newCompany.addEmployee(newEmployee2);
		newCompany.addEmployee(newEmployee3);
		
		PositionDetailsByCompany pd = new PositionDetailsByCompany();
		pd.setCompany(newCompany);
		pd.setMinSalary(600);
		pd.setPosition(developer);
		positionDetailsByCompanyRepository.save(pd);
		
		PositionDetailsByCompany pd2 = new PositionDetailsByCompany();
		pd2.setCompany(newCompany);
		pd2.setMinSalary(500);
		pd2.setPosition(tester);
		positionDetailsByCompanyRepository.save(pd2);

	}
}
