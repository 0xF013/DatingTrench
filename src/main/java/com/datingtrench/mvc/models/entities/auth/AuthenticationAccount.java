package com.datingtrench.mvc.models.entities.auth;

import com.datingtrench.mvc.base.AbstractEntity;
import com.datingtrench.mvc.models.entities.User;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

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

    @ManyToMany
    private List<Role> roles;

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

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
