package hr.kingict.controller;

import hr.kingict.model.Radar;
import hr.kingict.service.RadarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.sql.Date;
import java.util.List;

/**
 * Created by luka.crnjakovic on 5.6.2017..
 */
@Controller
public class HomeController {

    @Autowired
    private RadarService radarService;

    @GetMapping("/home")
    public String home(){
        return "hero";
    }

    @GetMapping("/home/{techGroup}")
    public String home(@PathVariable int techGroup, Model model){
        Radar r = radarService.getNewestRadar((long)techGroup);
        model.addAttribute("radarId", r.getId());
        model.addAttribute("start", String.valueOf(r.getStart()));
        model.addAttribute("dates", radarService.getCurrentRadarDates((long)techGroup));
        return "index_redesigned";
    }

    @GetMapping("/home/{techGroup}/{start}")
    public String home(@PathVariable int techGroup, @PathVariable String start, Model model){
        model.addAttribute("radarId", radarService.getRadarByDate(Date.valueOf(start),(long)techGroup).getId());
        model.addAttribute("dates", radarService.getCurrentRadarDates((long)techGroup));
        model.addAttribute("start", start);
        return "index_redesigned";
    }
}
