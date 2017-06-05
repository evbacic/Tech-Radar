package hr.kingict.repository;

import hr.kingict.model.Technology;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by luka.crnjakovic on 5.6.2017..
 */
@Repository
public interface TechnologyRepository extends JpaRepository<Technology, Long> {
}
