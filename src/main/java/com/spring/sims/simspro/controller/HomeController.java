package com.spring.sims.simspro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

@RestController
public class HomeController {

    private String appMode;

    @Autowired
    public HomeController(Environment environment){
        appMode = environment.getProperty("app-mode");
    }

//    @RequestMapping("/")
//    public String index(Model model){
//        model.addAttribute("datetime", new Date());
//        model.addAttribute("username", "John");
//        model.addAttribute("mode", appMode);
//
//        return "index";
//    }

    @RequestMapping(value = "/index")
    public String goHome() {

        return "login";
    }


    @RequestMapping(value = "help")
    public String getHelp() {

        return "Helpline number +001 ";
    }
}
