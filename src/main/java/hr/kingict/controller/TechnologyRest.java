package hr.kingict.controller;

import hr.kingict.model.Technology;
import hr.kingict.repository.TechnologyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by luka.crnjakovic on 7.6.2017..
 */
@RestController
@RequestMapping
public class TechnologyRest {

    @Autowired
    TechnologyRepository technologyRepository;

    @GetMapping("/api/radar")
    public List<Technology> findAll(){
        return technologyRepository.findAll();
    }

}
