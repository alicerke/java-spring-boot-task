package hu.steve.transport.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import hu.steve.transport.model.Milestone;

public interface MilestoneRepository extends JpaRepository<Milestone, Long> {
}
