package hu.webuni.hr.steve.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import hu.webuni.hr.steve.service.DefaultEmployeeService;
import hu.webuni.hr.steve.service.EmployeeService;

@Configuration
@Profile("!smart")
public class DefaultSalaryConfiguration {

	@Bean
	public EmployeeService employeeService() {
		return new DefaultEmployeeService();
	}
}
