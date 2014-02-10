package com.datingtrench.mvc.models.entities.auth;

import com.datingtrench.mvc.base.AbstractEntity;

import javax.persistence.Basic;
import javax.persistence.Entity;

/**
 * Created by elvis on 2/7/14.
 */

@Entity
public class Role extends AbstractEntity {

    @Basic
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
