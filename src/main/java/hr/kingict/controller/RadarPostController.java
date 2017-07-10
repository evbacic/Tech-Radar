package hr.kingict.controller;

import hr.kingict.model.CategoryUpdate;
import hr.kingict.model.NewRadar;
import hr.kingict.model.TechnologyToDelete;
import hr.kingict.service.RadarService;
import hr.kingict.service.RadarTechnologiesService;
import hr.kingict.service.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by luka.crnjakovic on 10.7.2017..
 */
@Controller
public class RadarPostController {

    @Autowired
    private TechnologyService technologyService;

    @Autowired
    private RadarService radarService;

    @Autowired
    private RadarTechnologiesService radarTechnologiesService;

    @RequestMapping(value="/api/category-updates",method= RequestMethod.POST)
    public @ResponseBody
    void modifyRadar(@RequestBody List<CategoryUpdate> list, HttpServletRequest request) {
        radarTechnologiesService.modifyRadarTechnologiesInformation(list);
    }

    @RequestMapping(value = "/api/radar-new", method = RequestMethod.POST)
    public @ResponseBody void getNewRadarInfo(@RequestBody NewRadar newRadar, HttpServletRequest request){
        radarService.addNewRadar(newRadar);
    }

    @RequestMapping(value="/api/delete",method=RequestMethod.POST)
    public @ResponseBody void  deleteTechnology(@RequestBody TechnologyToDelete tech, HttpServletRequest request) {
        technologyService.removeTechnology(tech);
    }
}
