package com.datingtrench.mvc.services;

import com.datingtrench.mvc.base.AbstractService;
import com.datingtrench.mvc.builders.UserBuilder;
import com.datingtrench.mvc.exceptions.ValidationException;
import com.datingtrench.mvc.models.entities.User;
import com.datingtrench.mvc.models.entities.auth.AuthenticationAccount;
import com.datingtrench.mvc.models.views.forms.FrontpageRegistrationForm;
import com.datingtrench.mvc.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by elvis on 2/9/14.
 */

@Service
@Transactional
public class UserService extends AbstractService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserBuilder builder;

    @Transactional
    public User beginRegistration(FrontpageRegistrationForm form) throws ValidationException {
        User user = builder.buildFrom(form);
        validate(user);
        // The validation checks for a unique email but there is still a very small chance that between check and creation the email would get registered.
        // so idk if it's worth bothering
        userRepository.saveAndFlush(user);
        return user;
    }

    @Transactional
    public User tryActivate(String activationCode) {
        User user = userRepository.findUserByActivationCode(activationCode);
        if (null == user) {
            return null;
        }
        AuthenticationAccount authenticationAccount = user.getAuthenticationAccount();
        authenticationAccount.setIsActive(true);
        authenticationAccount.setActivationCode(null);
        userRepository.saveAndFlush(user);
        return user;
    }


}
