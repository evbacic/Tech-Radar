package hr.kingict.repository;

import hr.kingict.model.Radar;
import hr.kingict.model.TechGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

/**
 * Created by luka.crnjakovic on 5.7.2017..
 */
@Repository
public interface RadarRepository extends JpaRepository<Radar, Long>{

    @Query("SELECT r from Radar r where r.start = ?1")
    List<Radar> findByDates(Date start);

    @Query("SELECT r from Radar r where r.start = (SELECT MAX(r.start) from r)")
    List<Radar> findRecentByGroup();

    @Query("SELECT distinct r.start from Radar r")
    List<Date> findAllDates();

    @Query("SELECT r.techGroupRadar from Radar r where r.id = ?1")
    List<TechGroup> findByGroup(Long id);
}
