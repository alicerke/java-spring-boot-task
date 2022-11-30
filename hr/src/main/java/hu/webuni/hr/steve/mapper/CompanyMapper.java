package hu.webuni.hr.steve.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import hu.webuni.hr.steve.dto.CompanyDto;
import hu.webuni.hr.steve.dto.EmployeeDto;
import hu.webuni.hr.steve.model.Company;
import hu.webuni.hr.steve.model.Employee;

@Mapper(componentModel = "spring")
public interface CompanyMapper {

	CompanyDto companyToDto(Company company);
	List<CompanyDto> companiesToDtos(List<Company> company);

	@Named("summary")
	@Mapping(target = "employees", ignore = true)
	CompanyDto companyToDtoWithNoEmployees(Company company);

	@IterableMapping(qualifiedByName = "summary")
	List<CompanyDto> companiesToDtosWithNoEmployees(List<Company> company);

	Company dtoToCompany(CompanyDto companyDto);
	
	@Mapping(target = "id", source = "employeeId")
	@Mapping(target = "title", source = "position.name")
	@Mapping(target = "entryDate", source = "dateOfStartWork")
	@Mapping(target = "company", ignore = true)
	EmployeeDto employeeToDto(Employee employee);

	@InheritInverseConfiguration
	Employee dtoToEmployee(EmployeeDto employeeDto);
	
	List<Employee> dtosToEmployees(List<EmployeeDto> employees);

}
