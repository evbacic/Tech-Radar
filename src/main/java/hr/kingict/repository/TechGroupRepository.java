package hr.kingict.repository;

import hr.kingict.model.TechGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * A Spring repository interface which works with TechGroup entities
 */
@Repository
public interface TechGroupRepository extends JpaRepository<TechGroup, Long> {
}
