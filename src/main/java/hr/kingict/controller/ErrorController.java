package hr.kingict.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by luka.crnjakovic on 10.7.2017..
 */
@Controller
public class ErrorController {
    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String getErrorPage(){
        return "unauthorized";
    }
}
