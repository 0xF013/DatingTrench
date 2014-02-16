package com.datingtrench.mvc.controllers;

import com.datingtrench.mvc.models.entities.User;
import com.datingtrench.mvc.models.views.forms.ResendActivationCodeForm;
import com.datingtrench.mvc.services.AuthenticationService;
import com.datingtrench.mvc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

/**
 * Created by elvis on 2/14/14.
 */

@Controller
public class ActivationController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationService authenticationService;

    @RequestMapping(value = "/public/activation/execute", method = RequestMethod.GET)
    public String activate(ModelMap model, @RequestParam(value = "activationCode", required = true) String activationCode) {
        User user = userService.tryActivate(activationCode);
        if (null == user) {
            return "/public/activation/invalidCode";
        }
        authenticationService.forceLogin(user);
        return "redirect:/";
    }

    @RequestMapping(value = "/public/activation/resend")
    public String resendActivation(ModelMap model, @RequestParam(value = "emailNotFound", required = false) Boolean emailNotFound) {
        if (null == emailNotFound) {
            emailNotFound = false;
        }
        model.put("emailNotFound", emailNotFound);
        model.put("form", new ResendActivationCodeForm());
        return "/public/activation/resendCode";
    }

    @RequestMapping(value = "/public/activation/resend", method = RequestMethod.POST)
    public String resendActivation(@Valid @ModelAttribute("form") ResendActivationCodeForm form, BindingResult result, ModelMap model) {
        boolean successfulResend = userService.tryResendActivationCode(form.getEmail());
        if (successfulResend) {
            return "redirect:/public/activation/sent";
        } else {
            return "redirect:/public/activation/resend?emailNotFound=true";
        }
    }

    @RequestMapping(value = "/public/activation/sent", method = RequestMethod.GET)
    public String activationSent() {
        return "/public/activation/activationSent";
    }
}
