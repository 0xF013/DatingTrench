package com.datingtrench.mvc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

/**
 * Created by elvis on 09.04.14.
 */
@Service
public class LocationService {

    @Autowired
    @Qualifier("entityManagerFactory")
    private EntityManagerFactory em;

    public void importLocationsFromFile() {
        Query query = em.createEntityManager().createQuery("insert into location(id, countrycode, zipcode) values(1, 'MD', 'MD-2000')");
        query.executeUpdate();
    }

}
