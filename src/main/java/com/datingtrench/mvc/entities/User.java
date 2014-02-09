package com.datingtrench.mvc.entities;

import com.datingtrench.mvc.base.AbstractEntity;
import com.datingtrench.mvc.entities.auth.AuthenticationAccount;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

/**
 * Created by elvis on 2/6/14.
 */

@Entity
public class User extends AbstractEntity {


    @Basic
    private String name;

    @Basic
    private String email;

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
}