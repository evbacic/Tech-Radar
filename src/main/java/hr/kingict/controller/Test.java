package hr.kingict.controller;

import hr.kingict.model.*;
import hr.kingict.repository.CategoryRepository;
import hr.kingict.repository.TechGroupRepository;
import hr.kingict.repository.TechnologyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by luka.crnjakovic on 5.6.2017..
 */
@Controller
public class Test {

    @Autowired
    TechnologyRepository technologyRepository;

    @Autowired
    TechGroupRepository techGroupRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping("/update/{radarId}")
    public String update(@PathVariable int radarId, Model model){
        model.addAttribute("radarId", radarId);
        List<Category> catList = categoryRepository.findAll();
        model.addAttribute("technology", new Technology());
        model.addAttribute("cats", catList);
        return "modify";
    }

    @PostMapping("/update/{radarId}")
    public String submitForm(@PathVariable int radarId, @ModelAttribute Technology technology, Model model){
        model.addAttribute("radarId", radarId);
        List<Category> catList = categoryRepository.findAll();
        model.addAttribute("cats", catList);
        TechGroup radarUsed = techGroupRepository.findOne(new Long(radarId));
        Technology newTech = new Technology(technology.getName(), technology.getDescription(), radarUsed, technology.getCategory());
        technologyRepository.saveAndFlush(newTech);
        return "redirect:/update/{radarId}";
    }

    @GetMapping("/home")
    public String home(Model model){
//        model.addAttribute("radarId", 0);
        return "hero";
    }

    @GetMapping("/home/{radarId}")
    public String home(@PathVariable int radarId, Model model){
        model.addAttribute("radarId", radarId);
        return "index_redesigned";
    }

    @RequestMapping(value="/api/category-updates",method=RequestMethod.POST)
    public @ResponseBody void  getSearchUserProfiles(@RequestBody List<CategoryUpdate> list, HttpServletRequest request) {

        for(int i = 0; i<list.size(); i++){
            Technology t = technologyRepository.findOne(list.get(i).getId());
            t.setCategory(categoryRepository.findOne(list.get(i).getCatId()));
            technologyRepository.saveAndFlush(t);
        }
    }

    @RequestMapping(value="/api/delete",method=RequestMethod.POST)
    public @ResponseBody void  deleteTechnology(@RequestBody TechnologyToDelete tech, HttpServletRequest request) {
        Technology t = technologyRepository.findOne(tech.getTechId());
        technologyRepository.delete(t);
    }

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String getErrorPage(){
        return "unauthorized";
    }

    @GetMapping("/home1")
    public String getIndex(){
        return "index_redesigned";
    }


}
