package com.datingtrench.mvc.models.entities;

import com.datingtrench.mvc.base.AbstractEntity;
import com.datingtrench.mvc.models.enums.Gender;
import com.datingtrench.mvc.models.validators.constraints.MinimalAge;
import com.datingtrench.mvc.models.validators.constraints.Unique;
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

@Entity(name = "Users")
public class User extends AbstractEntity {


    @NotNull
    @Enumerated
    private Gender gender;

    @NotNull
    @Size(min = 3, max = 20)
    @Basic
    private String name;

    @NotNull
    @NotEmpty
    @Email
    @Unique(tableName = "Users", property = "email")
    @Column(unique = true)
    private String email;


    @NotNull
    @Past
    @MinimalAge(18)
    @Temporal(TemporalType.DATE)
    private Date dob;


    @Temporal(TemporalType.TIMESTAMP)
    private Date registrationDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastActionDate;


    @Valid
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "user")
    private AuthenticationAccount authenticationAccount;


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
        if (null != email) {
            email = email.toLowerCase();
        }
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

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Date getLastActionDate() {
        return lastActionDate;
    }

    public void setLastActionDate(Date lastActionDate) {
        this.lastActionDate = lastActionDate;
    }
}