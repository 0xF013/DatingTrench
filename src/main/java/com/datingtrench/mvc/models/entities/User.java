package com.datingtrench.mvc.models.entities;

import com.datingtrench.mvc.base.AbstractEntity;
import com.datingtrench.mvc.models.entities.auth.AuthenticationAccount;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by elvis on 2/6/14.
 */

@Entity
public class User extends AbstractEntity {


    @Basic
    private String name;

    @Column(unique = true)
    private String email;

    @Temporal(TemporalType.DATE)
    private Date dob;

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