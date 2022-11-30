package hu.webuni.hr.steve.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import hu.webuni.hr.steve.model.PositionDetailsByCompany;

public interface PositionDetailsByCompanyRepository extends JpaRepository<PositionDetailsByCompany, Long> {

}
