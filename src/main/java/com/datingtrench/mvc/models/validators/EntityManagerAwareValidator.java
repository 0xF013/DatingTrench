package com.datingtrench.mvc.models.validators;

import javax.persistence.EntityManager;

/**
 * Created by elvis on 2/14/14.
 */
public interface EntityManagerAwareValidator {
    void setEntityManager(EntityManager entityManager);
}