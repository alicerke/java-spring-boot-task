package hu.webuni.hr.steve.web;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.web.reactive.server.WebTestClient;

import hu.webuni.hr.steve.dto.CompanyDto;
import hu.webuni.hr.steve.dto.EmployeeDto;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase
public class CompanyControllerIT {

	private static final String BASE_URI = "api/companies";

	@Autowired
	WebTestClient webTestClient;
	
	@Test
	void testThatAddedEmployeeToCompany() throws Exception {
		CompanyDto company = createCompany(new CompanyDto(null, 123, "Teszt", "teszt ut 1"));
		long companyId = company.getId();
		
		EmployeeDto employee = new EmployeeDto(null, "Teszt Elek", 100, LocalDateTime.now());
		addEmployeeToCompany(companyId, employee);
		
		CompanyDto companyAfter = getCompanyById(companyId);
		
		assertThat(companyAfter.getEmployees().subList(0, company.getEmployees().size()))
		.usingRecursiveFieldByFieldElementComparator()
		.containsExactlyElementsOf(company.getEmployees());
		
		assertThat(companyAfter.getEmployees().get(companyAfter.getEmployees().size()-1))
		.usingRecursiveComparison().ignoringFields("id");
	}
	
	@Test
	void testThatEmployeeIsRemoveFromCompany() throws Exception {
		CompanyDto company = createCompany(new CompanyDto(null, 123, "Teszt", "teszt ut 1"));
		long companyId = company.getId();
		
		EmployeeDto employee = new EmployeeDto(null, "Elek Teszt", 200, LocalDateTime.now());
		addEmployeeToCompany(companyId, employee);
		employee = new EmployeeDto(null, "Emilia", 500, LocalDateTime.now());
		company = addEmployeeToCompany(companyId, employee);
		
		List<EmployeeDto> employeesBefore = company.getEmployees();
		
		long employeeId = employeesBefore.get(0).getId();
		
		List<EmployeeDto> employeesAfter = removeEmployeeFromCompany(companyId, employeeId).getEmployees();
		
		assertThat(employeesBefore.size()).isNotEqualTo(employeesAfter.size());
	}
	
	@Test
	void testThatAllEmployeesHaveBeenChangedInCompany() throws Exception {
		CompanyDto company = createCompany(new CompanyDto(null, 123, "Teszt", "teszt ut 1"));
		long companyId = company.getId();
		
		EmployeeDto employee = new EmployeeDto(null, "Teszt Elek", 100, LocalDateTime.now());
		addEmployeeToCompany(companyId, employee);
		employee = new EmployeeDto(null, "Emilia", 500, LocalDateTime.now());
		company = addEmployeeToCompany(companyId, employee);
		
		List<EmployeeDto> employeesBefore = company.getEmployees();
		
		List<EmployeeDto> employeeListToReplaceWith = new ArrayList<EmployeeDto>();
		employeeListToReplaceWith.add(new EmployeeDto(null, "Aliz", 100, LocalDateTime.now()));
		employeeListToReplaceWith.add(new EmployeeDto(null, "Timi", 200, LocalDateTime.now()));
		employeeListToReplaceWith.add(new EmployeeDto(null, "Istvan", 300, LocalDateTime.now()));
		
		CompanyDto companyAfter = changeAllEmployeesInCompany(companyId, employeeListToReplaceWith);
		List<EmployeeDto> employeesAfter = companyAfter.getEmployees();
		
		assertThat(employeesAfter.containsAll(employeesBefore)).isFalse();
		
	}
	
	private CompanyDto createCompany(CompanyDto company) {
		return webTestClient
				.post()
				.uri(BASE_URI)
				.bodyValue(company)
				.exchange()
				.expectStatus()
				.isOk()
				.expectBody(CompanyDto.class)
				.returnResult()
				.getResponseBody();
	}
	
	private CompanyDto getCompanyById(long id) {
		return webTestClient
				.get()
				.uri(BASE_URI + "/" + id + "?full=true")
				.exchange()
				.expectStatus()
				.isOk()
				.expectBody(CompanyDto.class)
				.returnResult()
				.getResponseBody();
	}
	
	private CompanyDto addEmployeeToCompany(long companyId, EmployeeDto employee) {
		return webTestClient
			.post()
			.uri(BASE_URI + "/" + companyId + "/employees")
			.bodyValue(employee)
			.exchange()
			.expectStatus()
			.isOk()
			.expectBody(CompanyDto.class)
			.returnResult()
			.getResponseBody();
	}
	
	private CompanyDto removeEmployeeFromCompany(long companyId, long employeeId) {
		return webTestClient
				.delete()
				.uri(BASE_URI + "/" + companyId + "/employees/" + employeeId)
				.exchange()
				.expectStatus()
				.isOk()
				.expectBody(CompanyDto.class)
				.returnResult()
				.getResponseBody();
	}
	
	private CompanyDto changeAllEmployeesInCompany(long companyId, List<EmployeeDto> employees) {
		return webTestClient
				.put()
				.uri(BASE_URI + "/" + companyId + "/employees")
				.bodyValue(employees)
				.exchange()
				.expectStatus()
				.isOk()
				.expectBody(CompanyDto.class)
				.returnResult()
				.getResponseBody();
	}
}
