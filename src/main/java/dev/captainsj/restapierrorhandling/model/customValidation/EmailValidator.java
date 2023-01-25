package dev.captainsj.restapierrorhandling.model.customValidation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.hibernate.mapping.Constraint;

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
