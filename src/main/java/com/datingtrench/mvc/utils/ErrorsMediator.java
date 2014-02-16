package com.datingtrench.mvc.utils;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import java.util.Arrays;
import java.util.List;

/**
 * Created by elvis on 2/16/14.
 */
@Component
public class ErrorsMediator {

    public void merge(BindingResult e1, Errors e2) {
        for (FieldError error : e2.getFieldErrors()) {
            List<String> fieldErrorParts = Arrays.asList(error.getField().split("\\."));
            String fieldName = fieldErrorParts.get(fieldErrorParts.size() - 1);
            e1.addError(new FieldError(e1.getObjectName(), fieldName, error.getRejectedValue(), error.isBindingFailure(), error.getCodes(), error.getArguments(), error.getDefaultMessage()));
        }
    }
}
