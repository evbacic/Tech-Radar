package hr.kingict.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by emil-vid.bacic on 27.6.2017..
 */
@Controller
public class LoginController {

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

