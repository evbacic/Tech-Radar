package hr.kingict.service;

import hr.kingict.model.Technology;
import hr.kingict.model.TechnologyToDelete;

import java.util.List;

/**
 * A service interface which handles all business logic that deals with Technology models
 */
public interface TechnologyService {

    /**
     * A method which adds a new Technology object
     * @param technology Technology object
     * @param radarId id of Radar where it is used on
     */
    void addNewTechnology(Technology technology, Long radarId);

    /**
     * A method which gets all existing Technology objects
     * @return list of Technology objects
     */
    List<Technology> getAllTechnologies();

    /**
     * A method which deletes a Technology from the database
     * @param technologyToDelete TechnologyToDelete object holding information which Technology needs to be deleted
     */
    void removeTechnology(TechnologyToDelete technologyToDelete);
}
