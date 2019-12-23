package com.donnatto.ereservation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Class to handle the client login
 *
 * @author donnatto
 */
@Controller
@RequestMapping("/app")
public class LoginController {

    @GetMapping(value = {"/login", "/"})
    public ModelAndView login() {
        ModelAndView mav = new ModelAndView();
        String errorMessage = "User not authorized, must authenticate";
        mav.addObject("errorMsg", errorMessage);
        mav.setViewName("login");
        return mav;
    }

    @GetMapping("/home")
    public ModelAndView home() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("home");
        return mav;
    }
}
