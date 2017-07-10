package hr.kingict.service;

import hr.kingict.model.CategoryUpdate;
import hr.kingict.model.RadarTechnologies;

import java.util.List;

/**
 * Created by luka.crnjakovic on 10.7.2017..
 */
public interface RadarTechnologiesService {
    List<RadarTechnologies> getAllRadarTechnologies();
    void modifyRadarTechnologiesInformation(List<CategoryUpdate> updateList);
}
