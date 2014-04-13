package com.datingtrench.mvc.models.entities;

import com.datingtrench.mvc.base.AbstractEntity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Created by elvis on 09.04.14.
 */

@Entity
public class Location extends AbstractEntity{

    @Column(length = 2, nullable = false)
    private String countryCode;

    @Column(length = 7, nullable = false)
    private String zipCode;

    @Basic
    private String city;

    @Basic
    private String region;

    @Basic
    private Double latitude;

    @Basic
    private Double longitude;

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
}
