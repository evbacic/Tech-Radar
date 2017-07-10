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
 * Created by luka.crnjakovic on 7.6.2017..
 */
@RestController
@RequestMapping
public class RadarRestController {

    @Autowired
    private RadarTechnologiesService radarTechnologiesService;

    @Autowired
    private TechnologyService technologyService;

    @GetMapping("/api/radar")
    public List<RadarTechnologies> findAll() {
        return radarTechnologiesService.getAllRadarTechnologies();
    }

    @GetMapping("/api/technology")
    public List<Technology> findTech() {return technologyService.getAllTechnologies();}

}
