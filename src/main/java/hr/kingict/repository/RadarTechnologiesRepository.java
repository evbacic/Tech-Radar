package hr.kingict.repository;

import hr.kingict.model.RadarTechnologies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;

/**
 * Created by luka.crnjakovic on 5.7.2017..
 */
@Repository
public interface RadarTechnologiesRepository extends JpaRepository<RadarTechnologies, Long>{

}
