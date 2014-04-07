package com.datingtrench.mvc.models.enums;

import org.springframework.context.MessageSourceResolvable;

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
