package com.datingtrench.mvc.controllers;

import com.datingtrench.mvc.exceptions.ValidationException;
import com.datingtrench.mvc.models.views.forms.FrontpageRegistrationForm;
import com.datingtrench.mvc.services.AuthenticationService;
import com.datingtrench.mvc.services.UserService;
import com.datingtrench.mvc.utils.ErrorsMediator;
import com.datingtrench.mvc.utils.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by elvis on 2/7/14.
 */

@Controller
public class IndexController {


    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private UserService userService;

    @Autowired
    private TimeUtils timeUtils;

    @Autowired
    private ErrorsMediator errorsMediator;

    @ModelAttribute("years")
    public List<Integer> years() {
        return timeUtils.years();
    }

    @RequestMapping("/")
    public String index(ModelMap model, @RequestParam(value = "invalid_login", required = false) Boolean invalidCredentials) {

        if (!authenticationService.isAnonymous()) {
            model.clear();
            return "redirect:/users";
        }

        if (null == invalidCredentials) {
            invalidCredentials = false;
        }

        model.addAttribute("invalidCredentials", invalidCredentials);
        model.put("registrationForm", new FrontpageRegistrationForm());
        return "/public/index";
    }

    @RequestMapping(value = "/registration/plain", method = RequestMethod.POST)
    public String plainRegistration(
            @Valid
            @ModelAttribute("registrationForm")
            FrontpageRegistrationForm frontpageRegistrationForm,
            BindingResult result,
            Model model) {
        try {
            userService.beginRegistration(frontpageRegistrationForm);
        } catch (ValidationException e) {
            errorsMediator.merge(result, e);
        }
        if (result.hasErrors()) {
            System.out.println(result.getAllErrors());
            return "/public/index";
        } else {
            model.asMap().clear();
            return "redirect:/";
        }
    }


}
