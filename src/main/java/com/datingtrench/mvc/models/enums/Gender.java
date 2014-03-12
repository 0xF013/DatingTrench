package com.datingtrench.mvc.models.enums;

import javafx.application.Application;
import org.apache.tiles.request.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by elvis on 2/9/14.
 */

public enum Gender implements MessageSourceResolvable {
    FEMALE, MALE;

    @Override
    public String[] getCodes() {
        return new String[]{"xx" + name()};
    }

    @Override
    public Object[] getArguments() {
        return new Object[0];
    }

    @Override
    public String getDefaultMessage() {
        return "xxx" + name();
    }

}
