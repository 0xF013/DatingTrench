package com.datingtrench.mvc.models.entities;

import com.datingtrench.mvc.base.AbstractEntity;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by elvis on 2/9/14.
 */

@Entity
public class AuthenticationAccount extends AbstractEntity {


    @NotNull
    @Size(min = 6)
    @Basic
    private String password;

    @Basic
    private String activationCode;

    @Basic
    private Boolean isActive;

    @OneToOne
    private User user;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getActivationCode() {
        return activationCode;
    }

    public void setActivationCode(String activationCode) {
        this.activationCode = activationCode;
    }
}
