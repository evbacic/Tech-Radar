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
 * A Spring controller class used to map all ajax post requests from the presentation layer
 */
@Controller
public class RadarPostController {

    /**
     * A TechnologyService object used to perform business logic
     */
    @Autowired
    private TechnologyService technologyService;

    /**
     * A RadarService object used to perform business logic
     */
    @Autowired
    private RadarService radarService;

    /**
     * A RadarTechnologiesService object used to perform business logic
     */
    @Autowired
    private RadarTechnologiesService radarTechnologiesService;

    /**
     * A method that maps ajax post requests for updating radars from the presentation layer
     * @param list list of objects which store changes made in the presentation layer
     */
    @RequestMapping(value="/api/category-updates",method= RequestMethod.POST)
    public @ResponseBody
    void modifyRadar(@RequestBody List<CategoryUpdate> list) {
        radarTechnologiesService.modifyRadarTechnologiesInformation(list);
    }

    /**
     * A method that maps ajax post requests for saving changes as a new radar for specified period
     * @param newRadar an object which stores information about the new radar
     */
    @RequestMapping(value = "/api/radar-new", method = RequestMethod.POST)
    public @ResponseBody void getNewRadarInfo(@RequestBody NewRadar newRadar){
        radarService.addNewRadar(newRadar);
    }

    /**
     * A method that maps ajax post request for deleting a specific technology from the database
     * @param tech an object which stores information about the technology that needs to be deleted
     */
    @RequestMapping(value="/api/delete",method=RequestMethod.POST)
    public @ResponseBody void  deleteTechnology(@RequestBody TechnologyToDelete tech) {
        technologyService.removeTechnology(tech);
    }
}
