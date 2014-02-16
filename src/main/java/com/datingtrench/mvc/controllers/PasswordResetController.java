package com.datingtrench.mvc.controllers;

import com.datingtrench.mvc.models.views.forms.ResetPasswordForm;
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
 * Created by elvis on 2/16/14.
 */

@Controller
public class PasswordResetController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/password_reset/reset")
    public String resetPassword(ModelMap model, @RequestParam(value = "emailNotFound", required = false) Boolean emailNotFound) {
        if (null == emailNotFound) {
            emailNotFound = false;
        }
        model.put("emailNotFound", emailNotFound);
        model.put("form", new ResetPasswordForm());
        return "/public/passwordReset/reset";
    }

    @RequestMapping(value = "/password_reset/reset", method = RequestMethod.POST)
    public String resetPassword(@Valid @ModelAttribute("form") ResetPasswordForm form, BindingResult result, ModelMap model) {
        boolean successfulReset = userService.tryResetPassword(form.getEmail());
        if (successfulReset) {
            return "redirect:/password_reset/sent";
        } else {
            return "redirect:/password_reset/reset?emailNotFound=true";
        }
    }

    @RequestMapping(value = "/password_reset/sent", method = RequestMethod.GET)
    public String passwordSent() {
        return "/public/passwordReset/passwordSent";
    }
}
