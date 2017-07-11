package hr.kingict.repository;

import hr.kingict.model.Radar;
import hr.kingict.model.RadarTechnologies;
import hr.kingict.model.Technology;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * A Spring repository interface which works with RadarTechnologies entities
 */
@Repository
public interface RadarTechnologiesRepository extends JpaRepository<RadarTechnologies, Long>{

    /**
     * A method which gets the RadarTechnologies object with specified Technology and Radar value (their respective ids)
     * @param  t Technology object
     * @param  r Radar object
     * @return RadarTechnologies object
     */
    @Query("SELECT rt from RadarTechnologies rt where rt.technology = ?1 and rt.radar = ?2")
    RadarTechnologies findByParams(Technology t, Radar r);
}
