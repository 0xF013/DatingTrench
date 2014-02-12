package com.datingtrench.mvc.models.entities;

import com.datingtrench.mvc.base.AbstractEntity;
import com.datingtrench.mvc.models.entities.auth.AuthenticationAccount;
import com.datingtrench.mvc.models.validators.annotations.MinimalAge;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by elvis on 2/6/14.
 */

@Entity
public class User extends AbstractEntity {


    @NotNull
    @Size(min = 3, max = 20)
    @Basic
    private String name;


    @NotNull
    @NotEmpty
    @Email
    @Column(unique = true)
    private String email;


    @NotNull
    @Past
    @MinimalAge(18)
    @Temporal(TemporalType.DATE)
    private Date dob;


    @Valid
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "user")
    private AuthenticationAccount authenticationAccount;


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

    public AuthenticationAccount getAuthenticationAccount() {
        return authenticationAccount;
    }

    public void setAuthenticationAccount(AuthenticationAccount authenticationAccount) {
        this.authenticationAccount = authenticationAccount;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }
}