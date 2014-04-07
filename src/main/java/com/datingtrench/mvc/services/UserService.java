package com.datingtrench.mvc.services;

import com.datingtrench.mvc.base.AbstractService;
import com.datingtrench.mvc.components.SessionStorage;
import com.datingtrench.mvc.exceptions.ValidationException;
import com.datingtrench.mvc.models.builders.UserBuilder;
import com.datingtrench.mvc.models.entities.AuthenticationAccount;
import com.datingtrench.mvc.models.entities.User;
import com.datingtrench.mvc.models.views.forms.FrontpageRegistrationForm;
import com.datingtrench.mvc.repositories.UserRepository;
import com.datingtrench.mvc.utils.RandomStringGenerator;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by elvis on 2/9/14.
 */

@Service
@Transactional
public class UserService extends AbstractService {

    public static final int PASSWORD_LENGTH = 8;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MailService mailService;

    @Autowired
    private UserBuilder builder;

    @Autowired
    private RandomStringGenerator randomStringGenerator;

    @Autowired
    private SessionStorage sessionStorage;

    public User beginRegistration(FrontpageRegistrationForm form) throws ValidationException {
        User user = builder.buildFrom(form);
        validate(user);
        // The validation checks for a unique email but there is still a very small chance that between check and creation the email would get registered.
        // so idk if it's worth bothering
        userRepository.saveAndFlush(user);
        mailService.userRegistration(user);
        sessionStorage.setActivationCode(user.getAuthenticationAccount().getActivationCode());
        return user;
    }

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

    public boolean tryResendActivationCode(String email) {
        if (StringUtils.isEmpty(email)) {
            return false;
        }
        User user = userRepository.findInactiveUserByEmail(email);
        if (null == user) {
            return false;
        } else {
            mailService.resendActivationCode(user);
            sessionStorage.setActivationCode(user.getAuthenticationAccount().getActivationCode());
            return true;
        }
    }

    public boolean tryResetPassword(String email) {
        if (StringUtils.isEmpty(email)) {
            return false;
        }
        User user = userRepository.findActiveUserByEmail(email);
        if (null == user) {
            return false;
        } else {
            String password = resetPassword(user);
            mailService.resetPassword(user, password);
            return true;
        }
    }

    private String resetPassword(User user) {
        AuthenticationAccount authenticationAccount = user.getAuthenticationAccount();
        String password = randomStringGenerator.generate(PASSWORD_LENGTH);
        authenticationAccount.setPassword(password);
        userRepository.saveAndFlush(user);
        return password;
    }
}
