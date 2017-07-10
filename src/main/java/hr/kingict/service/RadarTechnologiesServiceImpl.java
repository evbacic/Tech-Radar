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
 * Created by luka.crnjakovic on 10.7.2017..
 */
@Component("radarTechnologiesService")
public class RadarTechnologiesServiceImpl implements RadarTechnologiesService{

    private final RadarTechnologiesRepository radarTechnologiesRepository;
    private final RadarRepository radarRepository;
    private final TechnologyRepository technologyRepository;
    private final CategoryRepository categoryRepository;


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
                r = radarRepository.findRecentById().get(0);
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
