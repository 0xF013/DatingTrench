package com.datingtrench.mvc.models.enums;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

/**
 * Created by elvis on 2/17/14.
 */
@Component
public class GenderFormatter implements Formatter<Gender> {

    @Autowired
    private MessageSource messageSource;

    @Override
    public String print(Gender object, Locale locale) {
        return messageSource.getMessage("enum.value.gender." + object.name(), null, "Male", locale);
    }

    @Override
    public Gender parse(String text, Locale locale) throws ParseException {
        if ("Male".equals(text))
            return Gender.MALE;
        else
            return Gender.FEMALE;
    }

}