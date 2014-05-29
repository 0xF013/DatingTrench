package com.datingtrench.mvc.services;

import com.datingtrench.mvc.models.entities.AuthenticationAccount;
import com.datingtrench.mvc.models.entities.User;
import com.datingtrench.mvc.models.enums.Gender;
import com.datingtrench.mvc.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by elvis on 16.05.14.
 * Used to populate the database with dev data at init (dev mode only)
 */

@Service
@Transactional
public class SeedingService implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private UserRepository userRepository;
    private boolean notInitialized = true;


    @Value("${env}")
    private String env;

    public void init() {
        User user = new User();
        Calendar cal = new GregorianCalendar();
        cal.add(Calendar.YEAR, -20);
        user.setDob(cal.getTime());
        user.setEmail("email@example.com");
        user.setGender(Gender.MALE);
        user.setLastActionDate(new Date());
        user.setName("JohnDoe");
        user.setRegistrationDate(new Date());
        AuthenticationAccount authenticationAccount = new AuthenticationAccount();
        authenticationAccount.setIsActive(true);
        authenticationAccount.setPassword("123123");
        authenticationAccount.setUser(user);
        user.setAuthenticationAccount(authenticationAccount);
        userRepository.saveAndFlush(user);

    }

    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (notInitialized && "development".equals(env)) {
            init();
            notInitialized = false;
        }
    }

}
