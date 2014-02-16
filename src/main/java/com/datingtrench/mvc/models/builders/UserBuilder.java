package com.datingtrench.mvc.models.builders;

import com.datingtrench.mvc.models.entities.AuthenticationAccount;
import com.datingtrench.mvc.models.entities.User;
import com.datingtrench.mvc.models.views.forms.FrontpageRegistrationForm;
import com.datingtrench.mvc.utils.RandomStringGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by elvis on 2/12/14.
 */

@Component
public class UserBuilder {

    public static final int ACTIVATION_CODE_LENGTH = 16;

    @Autowired
    RandomStringGenerator randomStringGenerator;

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
        authenticationAccount.setActivationCode(randomStringGenerator.generate(ACTIVATION_CODE_LENGTH));
        authenticationAccount.setUser(user);
        user.setAuthenticationAccount(authenticationAccount);


        return user;
    }
}
