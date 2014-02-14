package com.datingtrench.mvc.models.validators.constraints;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by elvis on 2/12/14.
 */

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MinimalAgeValidator.class)
public @interface MinimalAge {
    int value();

    String message() default "{com.datingtrench.mvc.models.validators.constraints.MinimalAge.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};


}
