package com.datingtrench.mvc.builders;

import com.datingtrench.mvc.models.entities.User;
import com.datingtrench.mvc.models.entities.auth.AuthenticationAccount;
import com.datingtrench.mvc.models.views.forms.FrontpageRegistrationForm;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by elvis on 2/12/14.
 */

@Component
public class UserBuilder {


    public User buildFrom(FrontpageRegistrationForm form) {

        User user = new User();
        user.setName(form.getName());
        user.setEmail(form.getEmail());
        user.setDob(form.getDob());
        user.setGender(form.getGender());

        user.setRegistrationDate(new Date());
        user.setLastActionDate(new Date());

        AuthenticationAccount authenticationAccount = new AuthenticationAccount();
        authenticationAccount.setPassword(form.getPassword());
        authenticationAccount.setIsActive(false);
        authenticationAccount.generateActivationCode();
        authenticationAccount.setUser(user);
        user.setAuthenticationAccount(authenticationAccount);


        return user;
    }
}
