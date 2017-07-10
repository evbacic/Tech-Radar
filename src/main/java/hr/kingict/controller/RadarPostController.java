package hr.kingict.controller;

import hr.kingict.model.*;
import hr.kingict.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.util.List;

/**
 * Created by luka.crnjakovic on 10.7.2017..
 */
@Controller
public class RadarPostController {

    @Autowired
    TechnologyRepository technologyRepository;

    @Autowired
    TechGroupRepository techGroupRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    RadarTechnologiesRepository radarTechnologiesRepository;

    @Autowired
    RadarRepository radarRepository;

    @RequestMapping(value="/api/category-updates",method= RequestMethod.POST)
    public @ResponseBody
    void getSearchUserProfiles(@RequestBody List<CategoryUpdate> list, HttpServletRequest request) {

        for(int i = 0; i<list.size(); i++){
            Radar r = radarRepository.findOne(list.get(i).getRadId());
            if(r==null){
                r = radarRepository.findRecentById().get(0);
            }
            RadarTechnologies rt = radarTechnologiesRepository.findByParams(technologyRepository.findOne(list.get(i).getId()), r);
            if(rt!=null){
                if(list.get(i).getCatId()==0){
                    radarTechnologiesRepository.delete(rt);
                }
                else{
                    rt.setCategory(categoryRepository.findOne(list.get(i).getCatId()));
                    radarTechnologiesRepository.saveAndFlush(rt);
                }
            }
            else{
                if(list.get(i).getCatId()!=0){
                    RadarTechnologies rtNew = new RadarTechnologies(r, technologyRepository.findOne(list.get(i).getId()), categoryRepository.findOne(list.get(i).getCatId()));
                    radarTechnologiesRepository.saveAndFlush(rtNew);
                }
            }

        }
    }

    @RequestMapping(value = "/api/radar-new", method = RequestMethod.POST)
    public @ResponseBody void getNewRadarInfo(@RequestBody NewRadar newRadar, HttpServletRequest request){
        Radar r = new Radar(techGroupRepository.findOne(newRadar.getTechGroupId()), Date.valueOf(newRadar.getStartDate()), Date.valueOf(newRadar.getEndDate()));
        radarRepository.saveAndFlush(r);
    }

    @RequestMapping(value="/api/delete",method=RequestMethod.POST)
    public @ResponseBody void  deleteTechnology(@RequestBody TechnologyToDelete tech, HttpServletRequest request) {
        Technology t = technologyRepository.findOne(tech.getTechId());
        technologyRepository.delete(t);
    }
}
