package hr.kingict.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * A Spring controller class used to map the 'login/logout' page
 */
@Controller
public class LoginController {

    /**
     * A method that maps the login and logout pages to the specified URL
     * @param model     an object used to pass various objects or collections of objects to presentation layer
     * @param logout    a String object that will modify login page adding a logout alert if provided
     * @param error     a String object that will modify login page adding 'access denied' warning if provided
     * @return          name of the mapped html file
     */
    @GetMapping("/login")
    public String loginForm(Model model,
                            @RequestParam(value = "logout", required = false) String logout,
                            @RequestParam(value = "error", required = false) String error) {
        if(logout != null){
            model.addAttribute("logoutMsg", "Logout Successful!");
        }

        if(error != null){
            model.addAttribute("errorMsg", "DENIED: Invalid Username and/or Password!");
        }

        return "login";
    }
}

