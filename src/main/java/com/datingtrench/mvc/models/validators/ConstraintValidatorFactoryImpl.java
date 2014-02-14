package com.datingtrench.mvc.models.validators;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorFactory;

/**
 * Created by elvis on 2/14/14.
 */
public class ConstraintValidatorFactoryImpl implements ConstraintValidatorFactory {

    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;

    @Override
    public <T extends ConstraintValidator<?, ?>> T getInstance(Class<T> key) {
        System.out.println("getInstance");
        T instance = null;

        try {
            instance = key.newInstance();
        } catch (Exception e) {
            // could not instantiate class
            e.printStackTrace();
        }

        if (EntityManagerAwareValidator.class.isAssignableFrom(key)) {
            EntityManagerAwareValidator validator = (EntityManagerAwareValidator) instance;
            validator.setEntityManager(entityManagerFactory.createEntityManager());
        }

        return instance;
    }

    @Override
    public void releaseInstance(ConstraintValidator<?, ?> constraintValidator) {

    }
}