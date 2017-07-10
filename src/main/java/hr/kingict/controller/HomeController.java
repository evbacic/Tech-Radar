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
public class HomeController {

    @Autowired
    TechGroupRepository techGroupRepository;

    @Autowired
    RadarRepository radarRepository;

    @GetMapping("/home")
    public String home(){
        return "hero";
    }

    @GetMapping("/home/{techGroup}")
    public String home(@PathVariable int techGroup, Model model){
        int radarId = 0;
        String start = "";
        List<Radar> list = radarRepository.findRecentByGroup(techGroupRepository.findOne((long)techGroup));
        Radar r = list.get(0);
            if(r.getTechGroupRadar().getId()==techGroup){
                radarId = (int)(long)(r.getId());
                start = String.valueOf(r.getStart());
            }

        model.addAttribute("radarId", radarId);
        model.addAttribute("start", start);
        model.addAttribute("dates", radarRepository.findAllDates(techGroupRepository.findOne(((long)techGroup))));
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
        model.addAttribute("dates", radarRepository.findAllDates(techGroupRepository.findOne((long)techGroup)));
        model.addAttribute("start", start);
        System.out.println(radarId);
        return "index_redesigned";
    }
}
