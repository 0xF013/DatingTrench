package com.datingtrench.mvc.controllers;

import com.datingtrench.mvc.entities.User;
import com.datingtrench.mvc.repositories.UserRepository;
import com.datingtrench.mvc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller

public class UserController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String listUsers(ModelMap model) {
        model.addAttribute("user", new User());
        model.addAttribute("users", userRepository.findAll());
        return "users";
    }

}