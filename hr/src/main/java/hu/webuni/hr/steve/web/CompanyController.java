package hu.webuni.hr.steve.web;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import hu.webuni.hr.steve.dto.CompanyDto;
import hu.webuni.hr.steve.dto.EmployeeDto;
import hu.webuni.hr.steve.mapper.CompanyMapper;
import hu.webuni.hr.steve.model.AverageSalaryByPosition;
import hu.webuni.hr.steve.model.Company;
import hu.webuni.hr.steve.repository.CompanyRepository;
import hu.webuni.hr.steve.service.CompanyService;

@RestController
@RequestMapping("/api/companies")
public class CompanyController {
	
	private CompanyMapper companyMapper;
	private CompanyService companyService;
	private CompanyRepository companyRepository;
	

	public CompanyController(CompanyMapper companyMapper, CompanyService companyService,
			CompanyRepository companyRepository) {
		super();
		this.companyMapper = companyMapper;
		this.companyService = companyService;
		this.companyRepository = companyRepository;
	}

	@GetMapping
	public List<CompanyDto> getAll(@RequestParam(required = false) Boolean full){
		List<Company> companies = isFull(full)? companyRepository.findAllWithEmployees() : companyService.findAll();
		List<CompanyDto> companyDtos = mapCompanies(companies, full);
		return companyDtos;
	}

	private List<CompanyDto> mapCompanies(List<Company> companies, Boolean full) {
		if(isFull(full))
			return companyMapper.companiesToDtos(companies);
		else
			return companyMapper.companiesToDtosWithNoEmployees(companies);
	}

	private boolean isFull(Boolean full) {
		return full != null && full;
	}
	
	@GetMapping("/{id}")
	public CompanyDto getById(@PathVariable long id, @RequestParam(required = false) Boolean full) {
		Company company = 
				(isFull(full) ? companyRepository.findByIdWithEmployees(id) : companyService.findById(id))
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
		if(isFull(full))
			return companyMapper.companyToDto(company);
		else
			return companyMapper.companyToDtoWithNoEmployees(company);
	}
	
	@PostMapping
	public CompanyDto createCompany(@RequestBody CompanyDto companyDto) {
      return companyMapper.companyToDto(companyService.save(companyMapper.dtoToCompany(companyDto)));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<CompanyDto> modifyCompany(@PathVariable long id, @RequestBody CompanyDto companyDto) {
		companyDto.setId(id);
		Company updatedCompany = companyService.update(companyMapper.dtoToCompany(companyDto));
		if (updatedCompany == null) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(companyMapper.companyToDto(updatedCompany));
	}
	
	@DeleteMapping("/{id}")
	public void deleteCompany(@PathVariable long id) {
		companyService.delete(id);
	}
	
	
	@PostMapping("/{id}/employees")
	public CompanyDto addNewEmployee(@PathVariable long id, @RequestBody EmployeeDto employeeDto) {

		return companyMapper.companyToDto(companyService.addEmployee(id, companyMapper.dtoToEmployee(employeeDto)));
	}

	
	@DeleteMapping("/{id}/employees/{employeeId}")
	public CompanyDto deleteEmployee(@PathVariable long id, @PathVariable long employeeId) {
		return companyMapper.companyToDto(companyService.deleteEmployee(id, employeeId));
	}
	
	@PutMapping("/{id}/employees")
	public CompanyDto replaceEmployees(@PathVariable long id, @RequestBody List<EmployeeDto> employees) {
		return companyMapper.companyToDto(companyService.replaceEmployees(id, companyMapper.dtosToEmployees(employees)));
	}
	
	
	@GetMapping(params = "aboveSalary")
	public List<CompanyDto> getCompaniesAboveSalary(@RequestParam int aboveSalary,
			@RequestParam(required = false) Boolean full) {
		List<Company> filteredCompanies = companyRepository.findByEmployeeWithSalaryHigherThan(aboveSalary);
		return mapCompanies(filteredCompanies, full);
	}
	
	@GetMapping(params = "aboveEmployeeNumber")
	public List<CompanyDto> getCompaniesAboveEmployeeNumber(@RequestParam int aboveEmployeeNumber,
			@RequestParam(required = false) Boolean full) {
		List<Company> filteredCompanies = companyRepository.findByEmployeeCountHigherThan(aboveEmployeeNumber);
		return mapCompanies(filteredCompanies, full);
	}
	
	@GetMapping("/{id}/salaryStats")
	public List<AverageSalaryByPosition> getSalaryStatsById(@PathVariable long id, @RequestParam(required = false) Boolean full) {
		return companyRepository.findAverageSalariesByPosition(id);
	}
		
}
