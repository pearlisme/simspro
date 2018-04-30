package com.spring.sims.simspro.controller;

import com.spring.sims.simspro.model.User;
import com.spring.sims.simspro.repository.UserRepository;
import com.spring.sims.simspro.service.UserService;
import com.spring.sims.simspro.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;


@RestController
public class HomeController {


    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/", "/login"}, method = RequestMethod.GET)
    public ModelAndView index() {

        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("login");
        System.out.println("modelAndView" + modelAndView);
        return modelAndView;
    }

    @RequestMapping(value = "/validate", method = RequestMethod.POST)
    public ModelAndView doValidate(@Valid User inputUser, BindingResult bindingResult) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", new User());
//        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//        bCryptPasswordEncoder.encode(user.getPassword());
//        System.out.println(bCryptPasswordEncoder);
//        BCrypt encruptedPassword = new BCrypt(user.getUserName());

        User userExists = userService.getUserByUserName(inputUser.getUserName());
        if (userExists != null) {

            if (userExists.getPassword().equals(inputUser.getPassword())) {
                modelAndView = new ModelAndView();
                modelAndView.setViewName("welcome");
                modelAndView.addObject("successMessage", "Welcome");
                modelAndView.addObject("user", userExists);
                return modelAndView;
            }


        } else {
            bindingResult
                    .rejectValue("username", "error.user",
                            "username or password doesn't match ");
            modelAndView.setViewName("login");
            System.out.println("modelAndView" + modelAndView);
            return modelAndView;
        }
        return modelAndView;
    }


    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView registration() {
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("registration");
        System.out.println("modelAndView" + modelAndView);
        return modelAndView;
    }


    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        User userExists = userService.getUserByUserName(user.getUserName());
        if (userExists != null) {
            bindingResult
                    .rejectValue("email", "error.user",
                            "There is already a user registered with the email provided");
            if (bindingResult.hasErrors()) {
                modelAndView.setViewName("registration");
            }
        } else {
            userService.saveUser(user);
            modelAndView.addObject("successMessage", "User has been registered successfully");
            modelAndView.addObject("user", new User());
            modelAndView.setViewName("registration");

        }
        return modelAndView;
    }

//    @RequestMapping(value="/admin/home", method = RequestMethod.GET)
//    public ModelAndView home(){
//        ModelAndView modelAndView = new ModelAndView();
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        User user = userService.findUserByEmail(auth.getName());
//        modelAndView.addObject("userName", "Welcome " + user.getName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
//        modelAndView.addObject("adminMessage","Content Available Only for Users with Admin Role");
//        modelAndView.setViewName("admin/home");
//        return "redirect:/";
//    }
}
