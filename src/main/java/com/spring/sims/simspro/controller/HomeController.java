package com.spring.sims.simspro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String login() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return "login";
    }

    @RequestMapping(value = "/index")
    public String goHome() {

        return "login";
    }


    @RequestMapping(value = "/help")
    public String getHelp() {

        return "Helpline number +001 ";
    }
}
