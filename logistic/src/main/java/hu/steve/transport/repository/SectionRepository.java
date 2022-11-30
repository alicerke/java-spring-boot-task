package hu.steve.transport.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import hu.steve.transport.model.Section;

public interface SectionRepository extends JpaRepository<Section, Long>{

}
