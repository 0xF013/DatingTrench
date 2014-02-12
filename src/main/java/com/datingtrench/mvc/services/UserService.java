package com.datingtrench.mvc.services;

import com.datingtrench.mvc.base.AbstractEntity;
import com.datingtrench.mvc.base.AbstractService;
import com.datingtrench.mvc.exceptions.ValidationException;
import com.datingtrench.mvc.mediators.RegistrationFormToUserMediator;
import com.datingtrench.mvc.models.entities.User;
import com.datingtrench.mvc.models.entities.auth.AuthenticationAccount;
import com.datingtrench.mvc.models.views.forms.FrontpageRegistrationForm;
import com.datingtrench.mvc.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.beanvalidation.SpringValidatorAdapter;

import java.util.List;

/**
 * Created by elvis on 2/9/14.
 */

@Service
public class UserService extends AbstractService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RegistrationFormToUserMediator mediator;


    @Autowired
    private SpringValidatorAdapter validator;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Transactional
    public User beginRegistration(FrontpageRegistrationForm form) throws ValidationException {
        User user = new User();

        AuthenticationAccount authenticationAccount = new AuthenticationAccount();
        authenticationAccount.setPassword(form.getPassword());
        authenticationAccount.setIsActive(true);
        user.setAuthenticationAccount(authenticationAccount);

        mediator.setForm(form);
        mediator.setUser(user);
        mediator.bind();

        ValidationException validationException = validate(user);
        try {
            userRepository.saveAndFlush(user);
        } catch (RuntimeException e) {

            validationException.rejectValue("email", "not_unique");
            // is unique fail, add field validationException to validationException and throw an exception again
            throw e;
        }
        return user;
    }


    private ValidationException validate(AbstractEntity e) throws ValidationException {
        ValidationException validationException = new ValidationException(e, e.getClass().getSimpleName());
        validator.validate(e, validationException);
        if (validationException.hasErrors()) {
            throw validationException;
        }

        return validationException;

    }


}
