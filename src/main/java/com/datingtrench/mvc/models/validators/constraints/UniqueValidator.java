package com.datingtrench.mvc.models.validators.constraints;

/**
 * Created by elvis on 2/13/14.
 */

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.io.Serializable;
import java.util.List;

@Component
public class UniqueValidator implements ConstraintValidator<Unique, Serializable>, ApplicationContextAware {

    private EntityManagerFactory entityManagerFactory;


    private String tableName;
    private String uniqueField;


    public void initialize(Unique unique) {
        tableName = unique.tableName();
        uniqueField = unique.property();
    }


    public boolean isValid(Serializable property, ConstraintValidatorContext cvContext) {
        String query = String.format("from %s as e where e.%s = ?1 ", tableName, uniqueField);
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query queryObject = entityManager.createQuery(query);
        queryObject.setParameter(1, property);
        List<?> result = queryObject.getResultList();
        return result.size() == 0;
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        entityManagerFactory = (EntityManagerFactory) applicationContext.getBean("entityManagerFactory");
    }
}