package com.datingtrench.mvc.models.validators.constraints;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by elvis on 2/12/14.
 */
public class MinimalAgeValidator implements ConstraintValidator<MinimalAge, Date> {

    private int validAge;


    @Override
    public void initialize(MinimalAge annotation) {
        validAge = annotation.value();
    }

    @Override
    public boolean isValid(Date date, ConstraintValidatorContext constraintValidatorContext) {
        if (date == null) {
            return true;
        }

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, -validAge);
        if (date.after(calendar.getTime())) {
            return false;
        }
        return true;
    }

}
