package hu.steve.transport.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import hu.steve.transport.model.Section;

public interface SectionRepository extends JpaRepository<Section, Long> {

	@Query("SELECT s FROM Section s "
			+ "WHERE s.transportplan.id = :transportplanId "
			+ "AND (s.fromMilestone.id = :milestoneId OR s.toMilestone.id = :milestoneId)")
	List<Section> findByTransportAndMilestoneId(Long transportplanId, Long milestoneId);

	@Query("SELECT max(s.sectionNumber) FROM Section s "
			+ "WHERE s.transportplan.id = :transportplanId")
	Integer findMaxSectionById(Long transportplanId);
	
	@Query("SELECT s FROM Section s "
			+ "WHERE s.fromMilestone.id = :milestoneId OR s.toMilestone.id = :milestoneId")
	Optional<Section> findByMilestoneId(Long milestoneId);

	@Query("SELECT s FROM Section s "
			+ "WHERE s.transportplan.id = :transportplanId "
			+ "AND s.sectionNumber = :sectionNumber")
	Optional<Section> findBySectionNumber(Long transportplanId, Integer sectionNumber);

}
