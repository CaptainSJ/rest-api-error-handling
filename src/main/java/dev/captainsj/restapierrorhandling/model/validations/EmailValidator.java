package dev.captainsj.restapierrorhandling.model.validations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EmailValidator implements ConstraintValidator<Email, String> {


    @Override
    public void initialize(Email constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return s != null &&
                s.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");

    }
}
