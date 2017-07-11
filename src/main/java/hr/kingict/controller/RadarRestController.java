package hr.kingict.controller;

import hr.kingict.model.RadarTechnologies;
import hr.kingict.model.Technology;
import hr.kingict.service.RadarTechnologiesService;
import hr.kingict.service.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * A Spring controller class that posts information from database to a specified URL
 * so the information can be used in the presentation layer
 */
@RestController
@RequestMapping
public class RadarRestController {

    /**
     * A RadarTechnologiesService object used to perform business logic
     */
    @Autowired
    private RadarTechnologiesService radarTechnologiesService;

    /**
     * A TechnologyService object used to perform business logic
     */
    @Autowired
    private TechnologyService technologyService;

    /**
     * A method that maps database information about RadarTechnologies entities to a specified URL
     * @return a list of all RadarTechnologies entities from the database
     */
    @GetMapping("/api/radar")
    public List<RadarTechnologies> findAll() {
        return radarTechnologiesService.getAllRadarTechnologies();
    }

    /**
     * A method that maps database information about Technology entities to a specified URL
     * @return a list of all Technology entities from the database
     */
    @GetMapping("/api/technology")
    public List<Technology> findTech() {return technologyService.getAllTechnologies();}

}
