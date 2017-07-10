package hr.kingict.repository;

import hr.kingict.model.Radar;
import hr.kingict.model.RadarTechnologies;
import hr.kingict.model.Technology;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by luka.crnjakovic on 5.7.2017..
 */
@Repository
public interface RadarTechnologiesRepository extends JpaRepository<RadarTechnologies, Long>{

    @Query("SELECT rt from RadarTechnologies rt where rt.technology = ?1 and rt.radar = ?2")
    RadarTechnologies findByParams(Technology t, Radar r);
}
