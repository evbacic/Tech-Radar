package hr.kingict.service;

import hr.kingict.model.Technology;
import hr.kingict.model.TechnologyToDelete;
import hr.kingict.repository.RadarRepository;
import hr.kingict.repository.TechnologyRepository;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by luka.crnjakovic on 10.7.2017..
 */
@Component("technologyService")
public class TechnologyServiceImpl implements TechnologyService {

    private final TechnologyRepository technologyRepository;

    private final RadarRepository radarRepository;

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
