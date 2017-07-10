package hr.kingict.service;

import hr.kingict.model.Technology;
import hr.kingict.model.TechnologyToDelete;

import java.util.List;

/**
 * Created by luka.crnjakovic on 10.7.2017..
 */
public interface TechnologyService {
    void addNewTechnology(Technology technology, Long radarId);
    List<Technology> getAllTechnologies();
    void removeTechnology(TechnologyToDelete technologyToDelete);
}
