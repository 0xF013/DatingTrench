package com.datingtrench.mvc.models.entities;

import com.datingtrench.mvc.base.AbstractEntity;

import javax.persistence.Basic;
import javax.persistence.Entity;

/**
 * Created by elvis on 14.04.14.
 */

@Entity
public class Post extends AbstractEntity{

    @Basic
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
