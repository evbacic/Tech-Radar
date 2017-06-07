package hr.kingict.controller;

import hr.kingict.model.Technology;
import hr.kingict.repository.TechnologyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by luka.crnjakovic on 7.6.2017..
 */
@RestController
@RequestMapping("/api/radar")
public class TechnologyRest {

    @Autowired
    TechnologyRepository technologyRepository;

    @GetMapping
    public List<Technology> findAll(){
        for(Technology tr: technologyRepository.findAll()){
            System.out.println(tr.toString());
        }
        return technologyRepository.findAll();
    }
}
