package hr.kingict.controller;

import hr.kingict.model.Technology;
import hr.kingict.service.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Created by luka.crnjakovic on 10.7.2017..
 */
@Controller
public class UpdateController {

    @Autowired
    private TechnologyService technologyService;

    @GetMapping("/update/{radarId}")
    public String update(@PathVariable int radarId, Model model){
        model.addAttribute("radarId", radarId);
        model.addAttribute("technology", new Technology());
        return "modify";
    }

    @PostMapping("/update/{radarId}")
    public String submitForm(@PathVariable int radarId, @ModelAttribute Technology technology, Model model){
        model.addAttribute("radarId", radarId);
        technologyService.addNewTechnology(technology, (long)radarId);
        return "redirect:/update/{radarId}";
    }
}