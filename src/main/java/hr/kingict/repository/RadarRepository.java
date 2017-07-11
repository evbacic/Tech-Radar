package hr.kingict.repository;

import hr.kingict.model.Radar;
import hr.kingict.model.TechGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

/**
 * A Spring repository interface which works with Radar entities
 */
@Repository
public interface RadarRepository extends JpaRepository<Radar, Long>{

    /**
     * A method which gets all Radar objects with specified start date
     * @param  start radar start date
     * @return list of Radar objects
     */
    @Query("SELECT r from Radar r where r.start = ?1")
    List<Radar> findByDates(Date start);

    /**
     * A method which gets all Radar objects with specified TechGroup value
     * and orders the result set in descending order based on Radar's start date
     * @param  techGroup TechGroup object
     * @return list of Radar objects
     */
    @Query("SELECT r from Radar r where r.techGroupRadar = ?1 order by r.start desc")
    List<Radar> findRecentByGroup(TechGroup techGroup);

    /**
     * A method which gets all starting dates from Radar table with specified TechGroup value
     * and orders the result set in descending order based on Radar's start date
     * @param  techGroup TechGroup object
     * @return list of Dates
     */
    @Query("SELECT distinct r.start from Radar r where r.techGroupRadar = ?1 order by r.start desc")
    List<Date> findAllDates(TechGroup techGroup);

    /**
     * A method which gets all TechGroup values from Radar table with specified Radar id
     * @param  id TechGroup id
     * @return list of TechGroup objects
     */
    @Query("SELECT r.techGroupRadar from Radar r where r.id = ?1")
    List<TechGroup> findByGroup(Long id);

    /**
     * A method which gets the Radar object with highest id value (newest radar)
     * @return Radar object
     */
    @Query("SELECT r from Radar r where r.id = (SELECT MAX(r.id) from r)")
    Radar findRecentById();

}
