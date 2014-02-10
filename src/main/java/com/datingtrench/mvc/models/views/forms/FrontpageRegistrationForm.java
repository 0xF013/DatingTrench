package com.datingtrench.mvc.models.views.forms;

import com.datingtrench.mvc.base.AbstractForm;
import com.datingtrench.mvc.models.enums.Gender;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by elvis on 2/9/14.
 */
public class FrontpageRegistrationForm extends AbstractForm {

    @NotNull
    private Gender gender;

    @NotEmpty
    @Size(min = 2, max = 30)
    private String name = "Ion";

    @NotEmpty
    @Email
    private String email;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @NotNull
    @Past
    private Date dob;

    @NotEmpty
    @Size(min = 6)
    private String password;

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
