package hr.kingict.controller;

import hr.kingict.model.*;
import hr.kingict.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.util.ArrayList;
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

    @Autowired
    RadarTechnologiesRepository radarTechnologiesRepository;

    @Autowired
    RadarRepository radarRepository;

    @GetMapping("/update/{radarId}")
    public String update(@PathVariable int radarId, Model model){
        model.addAttribute("radarId", radarId);
        model.addAttribute("technology", new Technology());
        return "modify";
    }

    @PostMapping("/update/{radarId}")
    public String submitForm(@PathVariable int radarId, @ModelAttribute Technology technology, Model model){
        model.addAttribute("radarId", radarId);
        Technology newTech = new Technology(technology.getName(), technology.getDescription(), radarRepository.findByGroup((long)radarId).get(0));
        technologyRepository.saveAndFlush(newTech);
        return "redirect:/update/{radarId}";
    }

    @GetMapping("/home")
    public String home(Model model){
        return "hero";
    }

    @GetMapping("/home/{techGroup}")
    public String home(@PathVariable int techGroup, Model model){
        int radarId = 0;
        String start = "";
        List<Radar> list = radarRepository.findRecentByGroup();
        for(Radar r: list){
            if(r.getTechGroupRadar().getId()==techGroup){
                radarId = (int)(long)(r.getId());
                start = String.valueOf(r.getStart());
            }
        }
        model.addAttribute("radarId", radarId);
        model.addAttribute("start", start);
        model.addAttribute("dates", radarRepository.findAllDates());
        return "index_redesigned";
    }

    @GetMapping("/home/{techGroup}/{start}")
    public String home(@PathVariable int techGroup, @PathVariable String start, Model model){
        int radarId = 0;
        List<Radar> list = radarRepository.findByDates(Date.valueOf(start));
        for(Radar r: list){
            if(r.getTechGroupRadar().getId()==techGroup){
                radarId = (int)(long)(r.getId());
            }
        }
        model.addAttribute("radarId", radarId);
        model.addAttribute("dates", radarRepository.findAllDates());
        model.addAttribute("start", start);
        System.out.println(radarId);
        return "index_redesigned";
    }

    @RequestMapping(value="/api/category-updates",method=RequestMethod.POST)
    public @ResponseBody void  getSearchUserProfiles(@RequestBody List<CategoryUpdate> list, HttpServletRequest request) {

        for(int i = 0; i<list.size(); i++){
                RadarTechnologies rt = radarTechnologiesRepository.findByParams(technologyRepository.findOne(list.get(i).getId()), radarRepository.findOne(list.get(i).getRadId()));
                if(rt!=null){
                    rt.setCategory(categoryRepository.findOne(list.get(i).getCatId()));
                    radarTechnologiesRepository.saveAndFlush(rt);
                }
                else{
                    RadarTechnologies rtNew = new RadarTechnologies(radarRepository.findOne(list.get(i).getRadId()), technologyRepository.findOne(list.get(i).getId()), categoryRepository.findOne(list.get(i).getCatId()));
                    radarTechnologiesRepository.saveAndFlush(rtNew);
            }

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

}
