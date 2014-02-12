package com.datingtrench.mvc.mediators;

import com.datingtrench.mvc.models.entities.User;
import com.datingtrench.mvc.models.views.forms.FrontpageRegistrationForm;
import org.springframework.stereotype.Component;

/**
 * Created by elvis on 2/12/14.
 */

@Component
public class RegistrationFormToUserMediator {

    private FrontpageRegistrationForm form;
    private User user;

    public FrontpageRegistrationForm getForm() {
        return form;
    }

    public void setForm(FrontpageRegistrationForm form) {
        this.form = form;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void bind() {
        user.setName(form.getName());
        System.out.println("email");
        System.out.println(form.getEmail());
        user.setEmail(form.getEmail());
        System.out.println("qqqqqq");
        System.out.println(form.getDob());
        System.out.println(form.getYear());
        System.out.println(form.getMonth());
        System.out.println(form.getDay());
        user.setDob(form.getDob());
        System.out.println(user.getDob());
    }


}
