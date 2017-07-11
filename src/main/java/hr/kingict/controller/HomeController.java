package hr.kingict.controller;

import hr.kingict.model.Radar;
import hr.kingict.service.RadarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.sql.Date;

/**
 * A Spring controller class used to map 'home/index' view and its sub-pages
 */
@Controller
public class HomeController {

    /**
     * A RadarService object used to perform business logic
     */
    @Autowired
    private RadarService radarService;

    /**
     * A method that maps the welcome page to URL of '/home'
     * @return name of the mapped html file
     */
    @GetMapping("/home")
    public String home(){
        return "hero";
    }

    /**
     * A method that maps the home page which includes the most recent radar for each technology group
     * @param   techGroup a number denoting the id of technology group to which currently visible radars belong to
     * @param   model an object used to pass various objects or collections of objects to presentation layer
     * @return  name of the mapped html file
     */
    @GetMapping("/home/{techGroup}")
    public String home(@PathVariable int techGroup, Model model){
        Radar r = radarService.getNewestRadar((long)techGroup);
        model.addAttribute("radarId", r.getId());
        model.addAttribute("start", String.valueOf(r.getStart()));
        model.addAttribute("dates", radarService.getCurrentRadarDates((long)techGroup));
        return "index_redesigned";
    }

    /**
     * A method that maps the home page which includes the specific radar from a given period
     * denoted by the period's start date
     * @param techGroup a number denoting the id of technology group to which currently visible radar belongs to
     * @param start     a String denoting the period start date of desired/visible radar
     * @param model     an object used to pass various objects or collections of objects to presentation layer
     * @return          name of the mapped html file
     */
    @GetMapping("/home/{techGroup}/{start}")
    public String home(@PathVariable int techGroup, @PathVariable String start, Model model){
        model.addAttribute("radarId", radarService.getRadarByDate(Date.valueOf(start),(long)techGroup).getId());
        model.addAttribute("dates", radarService.getCurrentRadarDates((long)techGroup));
        model.addAttribute("start", start);
        return "index_redesigned";
    }
}
