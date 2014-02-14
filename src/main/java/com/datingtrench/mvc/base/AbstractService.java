package com.datingtrench.mvc.base;

import com.datingtrench.mvc.exceptions.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.beanvalidation.SpringValidatorAdapter;

/**
 * Created by elvis on 2/6/14.
 */
abstract public class AbstractService {

    @Autowired
    private SpringValidatorAdapter validator;

    protected ValidationException validate(AbstractEntity e) throws ValidationException {
        ValidationException validationException = new ValidationException(e, e.getClass().getSimpleName());
        validator.validate(e, validationException);
        if (validationException.hasErrors()) {
            throw validationException;
        }
        return validationException;
    }
}
