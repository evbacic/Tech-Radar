package hr.kingict.controller;

import com.google.gson.Gson;
import hr.kingict.model.TechGroup;
import hr.kingict.model.Technology;
import hr.kingict.repository.TechGroupRepository;
import hr.kingict.repository.TechnologyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by luka.crnjakovic on 5.6.2017..
 */
@Controller
public class Test {

    @Autowired
    TechnologyRepository technologyRepository;

    @GetMapping("/radar")
    public String test(){
        return "test";
    }

    @GetMapping("/add")
    public String add(){
        return "create";
    }

    @GetMapping("/update")
    public String update(){
        return "modify";
    }

    @GetMapping("/home")
    public String home(){
        return "index";
    }
}
