package com.datingtrench.mvc.controllers;

import com.datingtrench.mvc.models.views.forms.FrontpageRegistrationForm;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by elvis on 2/7/14.
 */

@Controller
public class IndexController {


    @RequestMapping("/")
    public String index(ModelMap model, @RequestParam(value = "invalid_login", required = false) Boolean isLoginInvalid) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (!(auth instanceof AnonymousAuthenticationToken)) {
            return "redirect:/users";
        }

        if (null == isLoginInvalid) {
            isLoginInvalid = false;
        }

        model.addAttribute("isLoginInvalid", isLoginInvalid);
        model.addAttribute("registrationForm", new FrontpageRegistrationForm());
        return "index";

    }

}
