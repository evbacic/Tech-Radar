package hr.kingict.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * A Spring controller class used to map 'access denied' view to a specified URL
 */
@Controller
public class ErrorController {

    /**
     * A method that maps 'access denied' page to URL of '/403'
     * @return name of the mapped html file
     */
    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String getErrorPage(){
        return "unauthorized";
    }
}
