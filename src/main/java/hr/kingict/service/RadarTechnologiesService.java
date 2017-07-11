package hr.kingict.service;

import hr.kingict.model.CategoryUpdate;
import hr.kingict.model.RadarTechnologies;

import java.util.List;

/**
 * A service interface which handles all business logic that deals with RadarTechnologies models
 */
public interface RadarTechnologiesService {

    /**
     * A method which gets all existing RadarTechnologies objects
     * @return list of RadarTechnologies objects
     */
    List<RadarTechnologies> getAllRadarTechnologies();

    /**
     * A method which updates existing information about radars and technologies they include.
     * @param updateList list of CategoryUpdate objects which hold information about required updates
     */
    void modifyRadarTechnologiesInformation(List<CategoryUpdate> updateList);
}
