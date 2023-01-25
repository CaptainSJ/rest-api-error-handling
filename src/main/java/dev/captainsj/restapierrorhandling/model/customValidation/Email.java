package dev.captainsj.restapierrorhandling.model.customValidation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = EmailValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Email {
    String message() default "Invalid Enail";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
