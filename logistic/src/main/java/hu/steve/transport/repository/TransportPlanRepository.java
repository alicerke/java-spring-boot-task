package hu.steve.transport.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import hu.steve.transport.model.TransportPlan;

public interface TransportPlanRepository extends JpaRepository<TransportPlan, Long>{

}
