package me.matamor.backend.util.validation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class SimpleValidator {

    private final Validator validator;

    public boolean isValid(Object... objects) {
        for (Object object : objects) {
            Set<ConstraintViolation<Object>> violations = this.validator.validate(object);
            if (violations.size() > 0) {
                return false;
            }
        }

        return true;
    }
}
