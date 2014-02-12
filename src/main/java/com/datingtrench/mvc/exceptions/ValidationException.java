package com.datingtrench.mvc.exceptions;


import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;

/**
 * Created by elvis on 2/11/14.
 */
public class ValidationException extends BindException implements BusinessException {
    public ValidationException(BindingResult bindingResult) {
        super(bindingResult);
    }

    public ValidationException(Object target, String objectName) {
        super(target, objectName);
    }
}
