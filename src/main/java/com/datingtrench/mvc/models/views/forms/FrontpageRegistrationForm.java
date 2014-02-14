package com.datingtrench.mvc.models.views.forms;

import com.datingtrench.mvc.base.AbstractForm;
import com.datingtrench.mvc.models.enums.Gender;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by elvis on 2/9/14.
 */
public class FrontpageRegistrationForm extends AbstractForm {

    private Gender gender;

    private String name;

    private String email;

    private int day;
    private int month;
    private int year;


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


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Date getDob() {
        Calendar c = Calendar.getInstance();
        c.set(year, month - 1, day);
        return c.getTime();
    }


}
