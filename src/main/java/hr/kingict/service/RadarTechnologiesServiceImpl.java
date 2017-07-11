package hr.kingict.service;

import hr.kingict.model.CategoryUpdate;
import hr.kingict.model.Radar;
import hr.kingict.model.RadarTechnologies;
import hr.kingict.repository.CategoryRepository;
import hr.kingict.repository.RadarRepository;
import hr.kingict.repository.RadarTechnologiesRepository;
import hr.kingict.repository.TechnologyRepository;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * A class which is an implementation of RadarTechnologiesService interface
 */
@Component("radarTechnologiesService")
public class RadarTechnologiesServiceImpl implements RadarTechnologiesService{

    /**
     * RadarTechnologiesRepository object used to access RadarTechnologies information from the data access layer
     */
    private final RadarTechnologiesRepository radarTechnologiesRepository;
    /**
     * RadarRepository object used to access Radar information from the data access layer
     */
    private final RadarRepository radarRepository;
    /**
     * TechnologyRepository object used to access Technology information from the data access layer
     */
    private final TechnologyRepository technologyRepository;
    /**
     * CategoryRepository object used to access Category information from the data access layer
     */
    private final CategoryRepository categoryRepository;

    /**
     * A constructor with parameters for implementation of RadarTechnologiesService
     * @param radarTechnologiesRepository RadarTechnologiesRepository object
     * @param radarRepository RadarRepository object
     * @param technologyRepository TechnologyRepository object
     * @param categoryRepository CategoryRepository object
     */
    public RadarTechnologiesServiceImpl(RadarTechnologiesRepository radarTechnologiesRepository, RadarRepository radarRepository, TechnologyRepository technologyRepository, CategoryRepository categoryRepository) {
        this.radarTechnologiesRepository = radarTechnologiesRepository;
        this.radarRepository = radarRepository;
        this.technologyRepository = technologyRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<RadarTechnologies> getAllRadarTechnologies() {
        return radarTechnologiesRepository.findAll();
    }

    @Override
    public void modifyRadarTechnologiesInformation(List<CategoryUpdate> updateList) {
        for(int i = 0; i<updateList.size(); i++){
            Radar r = radarRepository.findOne(updateList.get(i).getRadId());
            if(r==null){
                r = radarRepository.findRecentById();
            }
            RadarTechnologies rt = radarTechnologiesRepository.findByParams(technologyRepository.findOne(updateList.get(i).getId()), r);
            if(rt!=null){
                if(updateList.get(i).getCatId()==0){
                    radarTechnologiesRepository.delete(rt);
                }
                else{
                    rt.setCategory(categoryRepository.findOne(updateList.get(i).getCatId()));
                    radarTechnologiesRepository.saveAndFlush(rt);
                }
            }
            else{
                if(updateList.get(i).getCatId()!=0){
                    RadarTechnologies rtNew = new RadarTechnologies(r, technologyRepository.findOne(updateList.get(i).getId()), categoryRepository.findOne(updateList.get(i).getCatId()));
                    radarTechnologiesRepository.saveAndFlush(rtNew);
                }
            }
        }
    }
}
