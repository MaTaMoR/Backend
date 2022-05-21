package me.matamor.backend.util.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidIdValidator implements ConstraintValidator<ValidId, Object> {

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }

        try {
            long parsedValue = Long.parseLong(String.valueOf(value));
            return parsedValue >= 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}