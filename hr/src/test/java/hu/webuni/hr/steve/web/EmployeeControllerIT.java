package hu.webuni.hr.steve.web;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.reactive.server.WebTestClient.ResponseSpec;

import hu.webuni.hr.steve.dto.EmployeeDto;

@AutoConfigureTestDatabase
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient(timeout = "99999999")
public class EmployeeControllerIT {
	
	private static final String BASE_URI="/api/employees";
	
	@Autowired
	WebTestClient webTestClient;
	
	
	private EmployeeDto validEmployee() {
		return new EmployeeDto(1L, "Test Elek", "tesztelő", 100, LocalDateTime.of(2018, 01, 28, 00, 00, 00, 00));
	} 
	
	private EmployeeDto invalidEmployee() {
		return new EmployeeDto(1L, "", "tesztelő", 100, LocalDateTime.of(2018, 01, 28, 00, 00, 00, 00));
	} 
	
	@Test
	void testThatPostEmployeeValidInput() throws Exception {
		List<EmployeeDto> allEmployeesBefore = getAllEmployees();
		EmployeeDto employeeValid = validEmployee();
		saveEmployee(employeeValid)
			.expectStatus()
			.isOk();
		
		List<EmployeeDto> allEmployeesAfter = getAllEmployees();

		assertThat(allEmployeesAfter.size()-1).isEqualTo(allEmployeesBefore.size());	
		assertThat(allEmployeesAfter.get(allEmployeesAfter.size()-1))
			.usingRecursiveComparison()
			.isEqualTo(employeeValid);
	}
	
	
	@Test
	void testThatPostEmployeeInvalidInput() throws Exception{
		List<EmployeeDto> allEmployeesBefore = getAllEmployees();
		EmployeeDto employeeInvalid = invalidEmployee();
		saveEmployee(employeeInvalid)
			.expectStatus()
			.isBadRequest();
		
		List<EmployeeDto> allEmployeesAfter = getAllEmployees();
			
		assertThat(allEmployeesAfter.size())
			.isEqualTo(allEmployeesBefore.size());
	}

	@Test
	void testThatPutEmployeeValidUpdate() throws Exception{
		EmployeeDto employee = validEmployee();
		saveEmployee(employee)
				.expectStatus()
				.isOk();
		
		List<EmployeeDto> allEmployeesBefore = getAllEmployees();
		employee.setName("valami");
		updateEmployee(employee)
			.expectStatus()
			.isOk();
		
		List<EmployeeDto> allEmployeesAfter = getAllEmployees();
		assertThat(allEmployeesAfter).hasSameSizeAs(allEmployeesBefore);
		assertThat(allEmployeesAfter.get(allEmployeesAfter.size()-1))
			.usingRecursiveComparison()
			.isEqualTo(employee);
	}
	
	@Test
	void testThatPutEmployeeInvalidUpdate() throws Exception{
		EmployeeDto employee = validEmployee();
		saveEmployee(employee)
				.expectStatus().isOk();
		
		List<EmployeeDto> allEmployeesBefore = getAllEmployees();
		EmployeeDto invalidEmployee = invalidEmployee();
		invalidEmployee.setId(employee.getId());
		updateEmployee(invalidEmployee)
		.expectStatus()
		.isBadRequest();
		
		List<EmployeeDto> allEmployeesAfter = getAllEmployees();
		
		assertThat(allEmployeesAfter).hasSameSizeAs(allEmployeesBefore);
		assertThat(allEmployeesAfter.get(allEmployeesAfter.size()-1))
		.usingRecursiveComparison()
		.isEqualTo(employee);
	}
	
	private ResponseSpec saveEmployee(EmployeeDto employeeDto) {
		return webTestClient
			.post()
			.uri(BASE_URI)
			.bodyValue(employeeDto)
			.exchange();
	}
	
	private ResponseSpec updateEmployee(EmployeeDto employeeDto) {
		return webTestClient
				.put()
				.uri(BASE_URI + "/" + employeeDto.getId())
				.bodyValue(employeeDto)
				.exchange();
	}

	private List<EmployeeDto> getAllEmployees() {
		List<EmployeeDto> responseList = webTestClient
				.get()
				.uri(BASE_URI)
				.exchange()
				.expectStatus()
				.isOk()
				.expectBodyList(EmployeeDto.class)
				.returnResult()
				.getResponseBody();
		
		Collections.sort(responseList, (a, b) -> Long.compare(a.getId(), b.getId()));
		return responseList;
	}

}
