package hr.kingict.repository;

import hr.kingict.model.Technology;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * A Spring repository interface which works with Technology entities
 */
@Repository
public interface TechnologyRepository extends JpaRepository<Technology, Long> {
}
