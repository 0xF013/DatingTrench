package com.datingtrench.mvc.controllers;

import com.datingtrench.mvc.exceptions.ValidationException;
import com.datingtrench.mvc.models.views.forms.FrontpageRegistrationForm;
import com.datingtrench.mvc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by elvis on 2/7/14.
 */

@Controller
public class IndexController {

    @Autowired
    private UserService userService;

    @ModelAttribute("years")
    public List<Integer> years() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        List<Integer> years = new ArrayList<Integer>();
        int currentYear = calendar.get(Calendar.YEAR);
        System.out.println("asdasdasdasdasd");
        System.out.println(currentYear);
        for (int i = currentYear; i > 1900; i--) {
            years.add(i);
        }
        return years;
    }

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
        model.put("registrationForm", new FrontpageRegistrationForm());
        return "index";
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
            for (ObjectError error : e.getAllErrors()) {
                result.addError(error);
                System.out.println(error);
            }
        }
        if (result.hasErrors()) {
            //.addAttribute("registrationForm", frontpageRegistrationForm);
            return "index";
        } else {
            return "redirect:/2=2";
        }
    }

}
