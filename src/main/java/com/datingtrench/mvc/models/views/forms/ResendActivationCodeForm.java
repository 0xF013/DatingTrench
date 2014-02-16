package com.datingtrench.mvc.models.views.forms;

import com.datingtrench.mvc.base.AbstractForm;

/**
 * Created by elvis on 2/16/14.
 */
public class ResendActivationCodeForm extends AbstractForm {

    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
