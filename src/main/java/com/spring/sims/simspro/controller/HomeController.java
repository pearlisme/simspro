package com.spring.sims.simspro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String goHome(){
        return "Hello world!";
    }


    @RequestMapping("/help")
    public String getHelp(){
        return "Helpline number +001 ";
    }
}
