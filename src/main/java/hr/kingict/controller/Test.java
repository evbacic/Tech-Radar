package hr.kingict.controller;

import hr.kingict.model.TechGroup;
import hr.kingict.model.Technology;
import hr.kingict.repository.TechGroupRepository;
import hr.kingict.repository.TechnologyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by luka.crnjakovic on 5.6.2017..
 */
@RestController
public class Test {

    @Autowired
    TechnologyRepository technologyRepository;

    @Autowired
    TechGroupRepository techGroupRepository;

    @RequestMapping("/test")
    public String test(){
        String output = "";
        for(Technology tg: techGroupRepository.findOne(1L).getTechnologyList()){
            output += tg.getName() + ", " + tg.getDescription() + " || ";
        }
        return output;
    }
}
