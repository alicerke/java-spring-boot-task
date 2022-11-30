package hu.webuni.hr.steve.repository;

import java.time.LocalDateTime;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import hu.webuni.hr.steve.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>, JpaSpecificationExecutor<Employee>{

	Page<Employee> findBySalaryGreaterThan(Integer minSalary, Pageable pageable);
	
	Page<Employee> findByPositionName(String jobTitle, Pageable pageable);
	
	Page<Employee> findByNameStartingWithIgnoreCase(String name, Pageable pageable);
	
	Page<Employee> findByDateOfStartWorkBetween(LocalDateTime start, LocalDateTime end, Pageable pageable);

	@Modifying
	@Transactional	
	@Query("UPDATE Employee e "
			+ "SET e.salary = :minSalary "
			+ "WHERE e.employeeId IN "
			+ "(SELECT e2.employeeId "
			+ "FROM Employee e2 "
			+ "WHERE e2.position.name=:position "
			+ "AND e2.salary < :minSalary "
			+ "AND e2.company.id=:companyId"
			+ ")")
	int updateSalaries(String position, int minSalary, long companyId);
}
