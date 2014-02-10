package com.datingtrench.mvc.models.validators;

import com.datingtrench.mvc.models.entities.User;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by elvis on 2/9/14.
 */
public class UserValidator implements Validator {

    public static final int VALID_AGE = 18;

    @Override
    public boolean supports(Class<?> aClass) {
        UserValidator uv = new UserValidator();
        return aClass.isAssignableFrom(User.class);

    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;
        validateDob(user.getDob(), errors);
    }

    private void validateDob(Date dob, Errors errors) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, -VALID_AGE);
        if (dob.after(calendar.getTime())) {
            errors.rejectValue("dob", "user_validation.too_young", new Object[]{VALID_AGE}, "Too young");
        }
    }


}
