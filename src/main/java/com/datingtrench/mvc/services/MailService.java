package com.datingtrench.mvc.services;

import com.datingtrench.mvc.base.AbstractService;
import com.datingtrench.mvc.models.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

/**
 * Created by elvis on 2/14/14.
 */

@Service
public class MailService extends AbstractService {

    private static final String FROM = "admin@datingtrench.com";
    private static final String ADMIN_EMAIL = "0xf013@gmail.com";

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private MailSender mailSender;

    public void userRegistration(User user) {
        sendRegistrationToUser(user);
        sendRegistrationMailToAdmin(user);
    }


    public void resendActivationCode(User user) {
        sendEmail(
                user.getEmail(),
                "mail.registration.activationResend.subject",
                "mail.registration.activationResend.text",
                new String[]{user.getAuthenticationAccount().getActivationCode()}
        );
    }

    private void sendRegistrationToUser(User user) {
        sendEmail(
                user.getEmail(),
                "mail.registration.activation.subject",
                "mail.registration.activation.text",
                new String[]{user.getAuthenticationAccount().getActivationCode()}
        );
    }

    private void sendRegistrationMailToAdmin(User user) {
        sendEmail(
                ADMIN_EMAIL,
                "mail.admin.newRegistration.subject",
                "mail.admin.newRegistration.text",
                new String[]{user.toString()}
        );
    }

    public void resetPassword(User user, String password) {
        sendEmail(
                user.getEmail(),
                "mail.registration.resetPassword.subject",
                "mail.registration.resetPassword.text",
                new String[]{password}
        );
    }

    private void sendEmail(String To, String subjectCode, String textCode, String[] textCodeArguments) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(FROM);
        simpleMailMessage.setSubject(messageSource.getMessage(subjectCode, null, null));
        simpleMailMessage.setText(messageSource.getMessage(textCode, textCodeArguments, null));
        simpleMailMessage.setTo(ADMIN_EMAIL);
        mailSender.send(simpleMailMessage);
    }


    private void sendEmail(String To, String subjectCode, String textCode) {
        sendEmail(To, subjectCode, textCode, null);
    }
}
