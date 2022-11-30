package hu.webuni.hr.steve.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import hu.webuni.hr.steve.model.Employee;

@Controller
public class EmployeeTLController {

	private List<Employee> allEmployees = new ArrayList<>();
	
//	{
//		allEmployees.add(new Employee(1L, "Kis István", "fejlesztő", 100, LocalDateTime.of(2012, 1, 1, 8, 0, 0)));
//	}
	
	@GetMapping("/employees")
	public String listEmployees(Map<String, Object> model) {
		model.put("employees", allEmployees);
		model.put("newEmployee", new Employee());
		return "employees";
	}
	
	@PostMapping("/employees")
	public String addEmployee(Employee employee) {
		allEmployees.add(employee);
		return "redirect:employees";
	}
	
	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable long id) {
		allEmployees.removeIf(item -> item.getEmployeeId() == id);
		return "redirect:/employees";
	}
	
	@GetMapping("/employees/{id}")
	public String listEmployee(@PathVariable long id, Map<String, Employee> model) {
		model.put("employee", allEmployees.stream().filter(item -> item.getEmployeeId() == id).findFirst().get());
		return "editEmployee";
	}
	
	@PostMapping("/updateEmployee")
	public String updateEmployee(Employee employee) {
		for (int i = 0; i < allEmployees.size(); i++) {
			if(allEmployees.get(i).getEmployeeId() == employee.getEmployeeId()) {
				allEmployees.set(i, employee);
				break;
			}
		}
		return "redirect:employees";
	}
}