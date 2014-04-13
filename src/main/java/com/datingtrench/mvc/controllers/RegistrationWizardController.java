package com.datingtrench.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by elvis on 08.04.14.
 */

@Controller
public class RegistrationWizardController {

    @RequestMapping(value="/registrationWizard/location", method = RequestMethod.GET)
    public String location(ModelMap model) {

        return "inside/registrationWizard/location";
    }

}
