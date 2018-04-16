package com.spring.sims.simspro.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/api/v1/")
public class HomeController {

    @RequestMapping("login")
    public String login() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return "login";
    }

    @RequestMapping(value = "index")
    public String goHome() {

        return "login";
    }


    @RequestMapping(value = "help")
    public String getHelp() {

        return "Helpline number +001 ";
    }
}
