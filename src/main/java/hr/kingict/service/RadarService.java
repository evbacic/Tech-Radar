package hr.kingict.service;

import hr.kingict.model.NewRadar;
import hr.kingict.model.Radar;

import java.sql.Date;
import java.util.List;

/**
 * A service interface which handles all business logic that deals with Radar models
 */
public interface RadarService {

    /**
     * A method which gets all existing radar start dates within a TechGroup
     * @param  techGroupId id of a TechGroup
     * @return list of start dates
     */
    List<Date> getCurrentRadarDates(Long techGroupId);

    /**
     * A method which gets the most recently added Radar
     * @param  techGroupId id of a TechGroup
     * @return Radar object
     */
    Radar getNewestRadar(Long techGroupId);

    /**
     * A method which gets a specific Radar object based on the specified date
     * @param  date starting date
     * @param  techGroupId id of a TechGroup
     * @return Radar object
     */
    Radar getRadarByDate(Date date, Long techGroupId);

    /**
     * A method which adds a new Radar object
     * @param newRadar NewRadar object
     */
    void addNewRadar(NewRadar newRadar);
}
