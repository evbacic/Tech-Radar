package hr.kingict.service;

import hr.kingict.model.Technology;
import hr.kingict.model.TechnologyToDelete;
import hr.kingict.repository.RadarRepository;
import hr.kingict.repository.TechnologyRepository;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * A class which is an implementation of TechnologyService interface
 */
@Component("technologyService")
public class TechnologyServiceImpl implements TechnologyService {

    /**
     * TechnologyRepository object used to access Technology information from the data access layer
     */
    private final TechnologyRepository technologyRepository;
    /**
     * RadarRepository object used to access Radar information from the data access layer
     */
    private final RadarRepository radarRepository;

    /**
     * A constructor with parameters for implementation of TechnologyService
     * @param technologyRepository TechnologyRepository object
     * @param radarRepository RadarRepository object
     */
    public TechnologyServiceImpl(TechnologyRepository technologyRepository, RadarRepository radarRepository) {
        this.technologyRepository = technologyRepository;
        this.radarRepository = radarRepository;
    }

    @Override
    public void addNewTechnology(Technology technology, Long radarId) {
        technologyRepository.saveAndFlush(new Technology(technology.getName(), technology.getDescription(), radarRepository.findByGroup(radarId).get(0)));
    }

    @Override
    public List<Technology> getAllTechnologies() {
        return technologyRepository.findAll();
    }

    @Override
    public void removeTechnology(TechnologyToDelete technologyToDelete) {
        technologyRepository.delete(technologyRepository.findOne(technologyToDelete.getTechId()));
    }
}
