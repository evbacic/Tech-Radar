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
 * A Spring controller class used to map the view which allows admins to update radars or create new
 */
@Controller
public class UpdateController {

    /**
     * A TechnologyService object used to perform business logic
     */
    @Autowired
    private TechnologyService technologyService;

    /**
     * A method that maps the update view and shows specified radar information to be updated
     * @param radarId database id of a specific radar to be updated
     * @param model   an object used to pass various objects or collections of objects to presentation layer
     * @return        name of the mapped html file
     */
    @GetMapping("/update/{radarId}")
    public String update(@PathVariable int radarId, Model model){
        model.addAttribute("radarId", radarId);
        model.addAttribute("technology", new Technology());
        return "modify";
    }

    /**
     * A method that maps the update view according to the form action in the presentation layer
     * Invoked when a user adds new technology via presentation layer form
     * @param radarId    database id of a specific radar to be updated
     * @param technology new technology object created using user provided information
     * @param model      an object used to pass various objects or collections of objects to presentation layer
     * @return
     */
    @PostMapping("/update/{radarId}")
    public String submitForm(@PathVariable int radarId, @ModelAttribute Technology technology, Model model){
        model.addAttribute("radarId", radarId);
        technologyService.addNewTechnology(technology, (long)radarId);
        return "redirect:/update/{radarId}";
    }
}
