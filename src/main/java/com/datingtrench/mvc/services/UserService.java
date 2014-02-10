package com.datingtrench.mvc.services;

import com.datingtrench.mvc.base.AbstractService;
import com.datingtrench.mvc.models.entities.User;
import com.datingtrench.mvc.models.entities.auth.AuthenticationAccount;
import com.datingtrench.mvc.models.validators.UserValidator;
import com.datingtrench.mvc.models.views.forms.FrontpageRegistrationForm;
import com.datingtrench.mvc.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindException;

import java.util.List;

/**
 * Created by elvis on 2/9/14.
 */

@Service
public class UserService extends AbstractService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User beginRegistration(FrontpageRegistrationForm form) {
        User user = new User();
        user.setName(form.getName());
        user.setDob(form.getDob());
        user.setEmail(form.getEmail());
        UserValidator userValidator = new UserValidator();
        BindException error = new BindException(user, "user");
        userValidator.validate(user, error);
        if (error.hasErrors()) {
            // throw validation exception here with errors as a field
        } else {
            // save
            // is unique fail, add field error to error and throw an exception again
        }
        AuthenticationAccount authenticationAccount = new AuthenticationAccount();
        authenticationAccount.setPassword(form.getPassword());
        authenticationAccount.setIsActive(true);
        user.setAuthenticationAccount(authenticationAccount);
        return user;
    }


}
