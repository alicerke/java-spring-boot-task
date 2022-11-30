package hu.webuni.hr.steve.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import hu.webuni.hr.steve.model.Position;

public interface PositionRepository extends JpaRepository<Position, Integer> {

	public Optional<Position> findByName(String name);
}
