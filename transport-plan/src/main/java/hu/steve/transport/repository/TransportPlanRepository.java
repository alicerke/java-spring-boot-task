package hu.steve.transport.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import hu.steve.transport.model.TransportPlan;

public interface TransportPlanRepository extends JpaRepository<TransportPlan, Long> {

	@EntityGraph("TransportPlan-full")
	@Query("SELECT t FROM TransportPlan t WHERE t.id=:id")
	Optional<TransportPlan> findById(Long id);
}
