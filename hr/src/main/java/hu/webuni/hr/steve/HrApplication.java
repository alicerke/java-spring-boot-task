package hu.webuni.hr.steve;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import hu.webuni.hr.steve.model.Employee;
import hu.webuni.hr.steve.service.InitDbService;
import hu.webuni.hr.steve.service.SalaryService;

@SpringBootApplication
public class HrApplication implements CommandLineRunner {
	
	@Autowired
	SalaryService salaryService;
	
	@Autowired
	InitDbService initDbService;

	public static void main(String[] args) {
		SpringApplication.run(HrApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		

		List<Employee> employees = new ArrayList<>();
		employees.add( new Employee(1L,"Steve Jobs", /*"fejlesztő",*/ 300, LocalDateTime.of(2018, 01, 28, 00, 00, 00, 00)));
		employees.add( new Employee(2L,"Elon Musk", /*"menedzser",*/ 200, LocalDateTime.of(2015, 03, 28, 00, 00, 00, 00)));
		employees.add( new Employee(3L,"Lewis Hamilton", /*"szakértő",*/ 400, LocalDateTime.of(2010, 03, 28, 00, 00, 00, 00)));
		employees.add( new Employee(4L,"Anthony Hopkins", /*"tesztelő",*/ 100, LocalDateTime.of(2021, 03, 28, 00, 00, 00, 00)));
		
		for (Employee employee : employees) {
			System.out.println("EmployeeID: " + employee.getEmployeeId() + " Employee old salary:" + employee.getSalary());
			salaryService.setNewSalary(employee);
			System.out.println("EmployeeID: " + employee.getEmployeeId() + " Employee new salary:" + employee.getSalary());
		}	
		
		initDbService.insertTestData();
		
	}

}
